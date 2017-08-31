package com.zhiyou.video.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomHandlerException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object obj,
			Exception exception) {	
		System.out.println("错误对象:"+obj);
		System.out.println("错误原因:"+exception);
		ModelAndView mw = new ModelAndView();
		mw.addObject("obj",obj);
		mw.addObject("exception",exception);
		mw.setViewName("/error");
		return mw;
	}

}
