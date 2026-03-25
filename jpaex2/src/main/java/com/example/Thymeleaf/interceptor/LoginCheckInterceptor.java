package com.example.Thymeleaf.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(">>> preHandler >>>");
		HttpSession session = request.getSession();
		session.getAttribute("username");
		Object loginUser = session.getAttribute("username");
		
		if(loginUser == null) { // 로그인이 안되었으면
			// 원래 가려던 URL을 세션에 저장
			String redirectURL = request.getRequestURI();
			System.out.println("원래 가려던 주소 : " + redirectURL);
			String queryString = request.getQueryString();
			System.out.println("쿼리스트링 : " + queryString);
			if(queryString != null) { // 쿼리스트링 주소에 합쳐주기
				redirectURL += "?" + queryString;
			}
			
			session.setAttribute("redirectURL", redirectURL);
			response.sendRedirect("/loginForm");
			
			return false;
		}
		
		return true;
	}
}
