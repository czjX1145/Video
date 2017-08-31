package com.zhiyou.video.controller.front;

import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.video.model.Data;
import com.zhiyou.video.model.Result;
import com.zhiyou.video.model.User;
import com.zhiyou.video.service.registerService;
import com.zhiyou.video.utils.MailUtil;

@Controller
public class fontLoginController {
    
	@Autowired
	registerService rs;
		
	@RequestMapping(value="/front/user/login.action",method=RequestMethod.POST)
	@ResponseBody
	public Result login(User user,HttpServletRequest request) {
		
		Result result = new Result();
	  	User user2 = rs.findLoginUser(user);
	  	if(user2 != null){ 
	  		result.setSuccess(true);
	  		request.getSession().setAttribute("_front_user",user2);
	  	}else {
			result.setSuccess(false);
			result.setMessage("请输入正确的用户名和密码");
		}		
		return result;
	}
	            
	@RequestMapping({"/front/user/outlogin.action","/front/user/logout.action"})
	public String outLogin(HttpServletRequest request,HttpSession session){
		request.getSession().setAttribute("_front_user", null);
		request.getSession().setAttribute("user", null);
		//session.invalidate();
		//此处有bug
		return "redirect:/index.jsp";	
	}
	
	//忘记密码                             /forgetpwd.action
	@RequestMapping("/forgetpwd.action")
	public String forgetpwd() {		
		return "/front/user/forget_pwd";
	}
	//邮件验证  
	@RequestMapping("/sendemail.action")
	@ResponseBody
	public Data sendemail(User user) throws Exception {
		Data data = new Data();
		Random ran = new Random();
	    int uuid=ran.nextInt(99999-10000+1)+10000;
	    
	   if( rs.addTestId(user,uuid)){
		   data.setSuccess(true);
	   }else {
		   data.setSuccess(false);
		   data.setMessage("发送失败");
	   }	    
		MailUtil.send(user.getEmail(), "你的验证码", ""+uuid);	
		return data;
	}
	
	// 提交邮箱以及验证码/forgetpwd.action
	@RequestMapping(value="/forgetpwd.action",method=RequestMethod.POST)
	public String sendTestId(User user,HttpServletRequest request) throws Exception {
		User user2 = rs.findTestId(user);
		if(user2 != null){
			request.getSession().setAttribute("_front_user", user2);
			return "/front/user/reset_pwd";
		}
		return "redirect:/forgetpwd.action";
	}
	
	//提交新密码   resetpwd.action
	@RequestMapping("/resetpwd.action")
	public String sendPwd(String password,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("_front_user");
		user.setPassword(password);
		int i = rs.updataPwd(user);		
		return "redirect:/index.jsp";
	}
	
	//跳转前台界面 
	@RequestMapping("/index.action")
	public String front(){		
		return "redirect:/index.jsp";
	}
	
	
	
}



