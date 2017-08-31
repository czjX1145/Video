package com.zhiyou.video.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class interceptor implements HandlerInterceptor {

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
		if(req.getSession().getAttribute("_front_user")!=null || req.getSession().getAttribute("user")!=null){
			
			return true;
		}else{
			if(req.getServletPath().equals("/front/user/login.action")||req.getServletPath().equals("/front/user/regist.action")){
				return true;
			}
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
			return false;
		}
		
		/*if(req.getSession().getAttribute("list")!=null||req.getServletPath().equals("/admin.action")){			
			return true;			
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
			return false;
		}	*/	
	 	/*return true;*/
	}

}
