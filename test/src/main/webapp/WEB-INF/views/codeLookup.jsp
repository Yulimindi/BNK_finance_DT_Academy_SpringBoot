<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/css/style.css">
<body>
	<header>
		<h1>할인점 주문 프로그램 ver 1.0</h1>
	</header>
	<nav id="nav">
		<a href="/goRegister">주문등록</a>
		<a href="/goOrderList">주문목록조회</a>
		<a href="/goOrderStatus">점포별주문현황</a>
		<a href="/goCode">제품코드조회</a>
		<a href="/">홈으로</a>
	</nav>
	

	
	<section>
		<h2>주문 목록</h2>
		<table>
			<thead>
				<tr>
					<th>제품코드</th>
					<th>제품명</th>
					<th>단가</th>
					<th>할인률(10%)</th>
					<th>할인률(15%)</th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach var="list" items="${list }">
				<tr>
					<td>${list.PCODE }</td>
					<td>${list.PNAME }</td>
					<td>${list.COST }</td>
					<td>${list.TEN }</td>
					<td>${list.FIF }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</section>
	
	<footer>
		어쩌구 저쩌구 푸터입니댕
	</footer>
</body>
</html>