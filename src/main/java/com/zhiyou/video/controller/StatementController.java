package com.zhiyou.video.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.video.service.statementService;
@RequestMapping("/admin")
@Controller
public class StatementController {

	@Autowired
	statementService ss;
	
	@RequestMapping("/statement_manage/statement_manage.action")
	public String statement(HttpServletRequest request,HttpServletResponse response){
		List<Integer> statementList = ss.findStatement();         		
		request.setAttribute("statementList", statementList);
		return "/statement_manage/statement_manage";
	}
	
}
