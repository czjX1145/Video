package com.zhiyou.video.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zhiyou.video.model.Admin;
import com.zhiyou.video.service.adminService;

@Controller
public class AdminController {

	@Autowired
	adminService as;    
	
	    //用户处理
		@RequestMapping("/admin/adminLogin.action")
		public String admin(HttpServletRequest request, Admin ad) {
			Admin findAdmin = as.findAdmin(ad);
			if(findAdmin != null){
				request.getSession().setAttribute("admin", findAdmin);
			return "forward:/admin/video_manage/video_list.action";				
			}else {
				return "/index";
			}						
		}	
		//用户退出
		@RequestMapping("/admin/outLogin.action")
		public String adminOut(HttpServletRequest request, Admin ad,HttpSession session) {			
			request.getSession().setAttribute("admin",null);			
				return "/index";
			}						
		}	
		
		

