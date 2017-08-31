package com.zhiyou.video.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class interceptorAdmin implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		if(req.getSession().getAttribute("admin")!=null ){			
			return true;
		}else{
			if(req.getServletPath().equals("/admin/adminLogin.action")){
				return true;
			}else {
				resp.sendRedirect(req.getContextPath()+"/WEB-INF/web/index.jsp");
				return false;
			}			
		}
	}

}
