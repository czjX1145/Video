package com.zhiyou.video.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.video.model.Result;
import com.zhiyou.video.model.User;
import com.zhiyou.video.service.registerService;

@Controller
public class fontRegisterController {

	@Autowired
	registerService rs;
		
	@RequestMapping("/front/user/regist.action")
	@ResponseBody
	public  Result frontRegister(User user) {
		Result result = new Result();
		result.setSuccess(rs.registerUser(user));
		if(!rs.registerUser(user)){
			result.setMessage("此用户已存在");
		}		
		return result;
	}
}
                                                                      
