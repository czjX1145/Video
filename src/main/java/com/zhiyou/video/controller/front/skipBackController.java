package com.zhiyou.video.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class skipBackController {

	@RequestMapping("/backstageLogin.action")
	public String skipBack() {		
		return "/index";
	}
	
}
