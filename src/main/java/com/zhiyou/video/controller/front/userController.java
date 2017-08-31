package com.zhiyou.video.controller.front;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import com.zhiyou.video.model.User;
import com.zhiyou.video.service.registerService;

@Controller
public class userController {

	@Autowired
	registerService rs;
	//跳转到 用户资料的 jsp界面
	@RequestMapping("/front/user/index.action")
	public String userMessage(HttpServletRequest request) {	
		 User user = (User)request.getSession().getAttribute("_front_user");
		 User user2 = rs.findLoginUser(user.getEmail());
		 request.getSession().setAttribute("user", user2);
		return "/front/user/index";
	}
	
	//跳转到  更改用户资料  的jsp中
	@RequestMapping("/front/user/profile.action")
	public String userProfile() {    		
		return "/front/user/profile";
	}
	
	
	
	//提交用户更改资料   表单信息   
	@RequestMapping(value="/front/user/profile.action",method=RequestMethod.POST)
	public String userUpdateMessage(User user,HttpServletRequest request) {
	  User user2 = (User)request.getSession().getAttribute("_front_user");
		user.setUpdateTime(new Date(System.currentTimeMillis()));
		user.setEmail(user2.getEmail());
		int i = rs.updateUser(user);
		return "redirect:/front/user/index.action";
	}
	
	//跳转到更改头像的 jsp界面    
	@RequestMapping("/front/user/avatar.action")
	public String skipupdateUserHead() {
		return "/front/user/avatar";
	}
	//上传头像
	@RequestMapping(value= "/front/user/avatar.action",method=RequestMethod.POST)
	public String updateUserHeader(User user,MultipartFile image_file,HttpServletRequest request) throws IllegalStateException, IOException {
		 User user2 = (User)request.getSession().getAttribute("user");
		 user.setEmail(user2.getEmail());
		String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());
		String str = UUID.randomUUID().toString().replaceAll("-", "");
		String fileName = str+"."+ext;
		String upload = "D:\\Develop\\upload";		
		image_file.transferTo(new File(upload+"\\"+fileName));
		user.setHeadUrl(fileName);
		rs.updateUser(user);				
		return "redirect:/front/user/index.action";
	}
	
	//跳转到密码安全界面
	@RequestMapping("/front/user/password.action")
	public String skipPwdSafety() {		
		return "/front/user/password";
	}
	
	//密码安全更改密码 
	@RequestMapping(value="/front/user/password.action",method=RequestMethod.POST)
	public String pwdSafety(User user,String newPassword,String oldPassword) {
		System.out.println("测试修改密码"+user+"----"+newPassword+"---------"+oldPassword);
		user.setPassword(oldPassword);
		User user2 = rs.findLoginUser2(user);
		if(user2!=null){
			user.setPassword(newPassword);
			rs.updataPwd(user);
			return "redirect:/front/user/index.action";
		}else{
			return "redirect:/front/user/password.action";
		}
		
	}
	
	
}
