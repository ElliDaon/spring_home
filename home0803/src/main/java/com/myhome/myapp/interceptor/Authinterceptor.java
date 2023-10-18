package com.myhome.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Authinterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception{

		HttpSession session = request.getSession();
		boolean tf = false;
		
		if(session.getAttribute("midx")==null) {
			
			saveUrl(request);
			
			String location = request.getContextPath()+"/member/memberLogin.do";
			response.sendRedirect(location);
			tf = false;
		}else {
			tf = true;
		}	
		
		return true;
	}
	
	public void saveUrl(HttpServletRequest req) {
		String uri = req.getRequestURI(); //전체경로 주소
		String query = req.getQueryString(); //파라미터
		
		if(query == null || query.equals("null")) {
			query="";
		}else {
			query = "?"+query;
		}
		System.out.println("url"+uri+query);
		if(req.getMethod().equals("GET")) {
			req.getSession().setAttribute("saveUrl", uri+query);
		}
	}

}
