package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Comment;
import com.example.demo.dto.Member;
import com.example.demo.dto.Post;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

@Repository
public class DB {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	// 회원가입
	public int join(Member m) {
		String query = "insert into mypage_member values (?, ?, ?)";
		int result = jdbc.update(query, m.getId(), m.getPw(), m.getName());
		return result;
	}
	
	public int check(String id) {
		int result = 0;
		String query = "select count(*) from mypage_member where id = ?";
		result = jdbc.queryForObject(query, Integer.class, id);
		return result;
	}
	
	// 로그인
	public int login(Member m) {
		int result = 0;
		String query = "select count(*) from mypage_member where id = ? and pw = ?";
		result = jdbc.queryForObject(query, Integer.class, m.getId(), m.getPw());
		return result;
	}
	
	// 해당 멤버 가져오기
	public Member getMember(Member m) {
		String query = "select * from mypage_member where id = ? and pw = ?";
		Member member = jdbc.queryForObject(query, new BeanPropertyRowMapper<Member>(Member.class), m.getId(), m.getPw());
		return member;
	}
		
	// post 작성
	public int getLength() {
		String query = "select count(*) from mypage_post";
		int result = jdbc.queryForObject(query, Integer.class);
		return result;
	}
	
	// 메인 페이지 테이블 가져오기
	public List<Post> getPost(int page) {
		String query = "select m.name, p.indexx, p.post_title, p.post_content, p.post_date from mypage_post p join mypage_member m on p.id = m.id order by indexx desc offset ? rows fetch next 10 rows only";
		List<Post> list = jdbc.query(query, new BeanPropertyRowMapper<Post>(Post.class), page);
		return list;
	}
	
	public List<Post> fakegetPost() {
		String query = "select m.name, p.indexx, p.post_title, p.post_content, p.post_date from mypage_post p join mypage_member m on p.id = m.id order by indexx desc";
		List<Post> list = jdbc.query(query, new BeanPropertyRowMapper<Post>(Post.class));
		return list;
	}
	
	// 게시글 작성
	public int createPost(Post p, HttpSession session) {
		int result = 0;
		String query = "insert into mypage_post (indexx, id, post_title, post_content) values (seq_post.nextval, ?, ?, ?)";
		result = jdbc.update(query, (String) session.getAttribute("id"), p.getPost_title(), p.getPost_content());
		return result;
	}
	
	// 게시글 디테일 페이지
	public Post getOnePost(String indexx) {
		System.out.println("getOnePost 진입");
		int index = Integer.parseInt(indexx);
		System.out.println("DB index : " + index);
		String query = "select m.name, p.indexx, p.post_title, p.post_content, p.post_date, m.id from mypage_post p join mypage_member m on p.id = m.id where indexx = ?";
		Post p = jdbc.queryForObject(query, new BeanPropertyRowMapper<Post>(Post.class), index);
		System.out.println("getonepost : " + p);
		return p;
	}
	
	// 게시글 삭제
	public int deletePost(int index) {
		int result = 0;
		String query = "delete from mypage_post where indexx = ?";
		result = jdbc.update(query, index);
		return result;
	}
	
	// 게시글 수정
	public int updatePost(int index, String post_title, String post_content) {
		System.out.println("updatepost 진입");
		int result = 0;
		String query = "update mypage_post set post_title = ?, post_content = ? where indexx = ?";
		result = jdbc.update(query, post_title, post_content, index);
		return result;
	}
	
	// 댓글 작성
	public int insertComment(int indexx, String id, String name, String commentt) {
		int result = 0;
		String query = "insert into mypage_comment (indexx, id, name, commentt) values (?, ?, ?, ?)";
		result = jdbc.update(query, indexx, id, name, commentt);
		
		return result;
	}
	
	// 댓글 전체 반환
	public List<Comment> getComment(int indexx) {
		String query = "select * from mypage_comment where indexx = ?";
		List<Comment> list = jdbc.query(query, new BeanPropertyRowMapper<Comment>(Comment.class), indexx);
		return list;
	}
	
	// 댓글 삭제
	public int deleteComment(int index, String name, String commentt) {
		int result = 0;
		String query = "delete from mypage_comment where indexx = ? and name = ? and commentt = ?";
		result = jdbc.update(query, index, name, commentt);
		return result;
	}
	
	
}
