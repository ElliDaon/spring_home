package com.myhome.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override // �ڵ鷯(�޼ҵ�) ���Ŀ� ó�����
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		String midx = (String) modelAndView.getModel().get("midx");
		String memberName = (String) modelAndView.getModel().get("memberName");

		modelAndView.getModel().clear(); // �ĸ����� model �� �����

		if (midx != null) {
			// ��Ʈ�ѷ����� ���� �𵨰� ������ ���ǿ� ���
			request.getSession().setAttribute("midx", midx);
			request.getSession().setAttribute("memberName", memberName);
		}
	}

	@Override // �ڵ鷯�� ���� ���� ������ �����ϰ� �����Ѵ�.
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession(false);

		if (session.getAttribute("midx") != null) {
			session.removeAttribute("midx");
			session.removeAttribute("memberName");
		}
		return true;
	}
}