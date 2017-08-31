package com.zhiyou.video.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.zhiyou.video.model.Speaker;
import com.zhiyou.video.service.lecturerService;
import com.zhiyou.video.utils.Page;


@RequestMapping("/admin")
@Controller
public class LecturerController {

	@Autowired
	lecturerService ls;
	
	 //用户处理                         
	@RequestMapping("/lecturer_manage/lecturer_manage.action")
	public String lecturerList(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(defaultValue="")String speakerName,
			@RequestParam(defaultValue="")String speakerJob,
			@RequestParam(defaultValue="1")int page) {
		request.setAttribute("speakerName", speakerName);
		request.setAttribute("speakerJob", speakerJob);
		
		Page<Speaker> pageinfo = ls.findPageSpeaker(speakerName,speakerJob,page);
		request.setAttribute("page",pageinfo);
		System.out.println(pageinfo.getRows());
		return "/lecturer_manage/lecturer_manage";
	}
	
	@RequestMapping("/lecturer_manage/skipaddlecturer.action")
	public String skipaddLecturer(){		
		return "/lecturer_manage/lecturer_add";
	}
	//添加主讲人
	@RequestMapping("/lecturer_manage/addlecturer.action")
	public String addLecturer(HttpServletRequest request,HttpServletResponse response,Speaker speaker){
		System.out.println("测试speaker"+speaker);
		ls.addSpeaker(speaker);
		//此处有bug
		return "redirect:/admin/lecturer_manage/lecturer_manage.action";
	}
	//lecturer_manage/skip_lecturer_edit.action
	@RequestMapping("/lecturer_manage/skip_lecturer_edit.action")
	public String skipEditLecturer(HttpServletRequest request,HttpServletResponse response,int id){		
		Speaker speaker = ls.findSpeakerById(id);
		request.setAttribute("speaker", speaker);
		System.out.println("测试speaker_id"+speaker);
		return "/lecturer_manage/lecturer_edit";		
	}
	
	@RequestMapping("/lecturer_manage/update_lecturer.action")
	public String updateLecturer(HttpServletRequest request,HttpServletResponse response,Speaker speaker){		
		ls.updateSpeaker(speaker);		
		System.out.println("测试speaker_id"+speaker);
		return "redirect:/admin/lecturer_manage/lecturer_manage.action";		
	}
    //lecturer_manage/delete_lecturer.action 这个路径有bug
	@RequestMapping("/lecturer_manage/updatelecturer.action")
	public String deleteLecturer(HttpServletRequest request,HttpServletResponse response,int id){		
		ls.deleteSpeaker(id);
		return "forward:/admin/lecturer_manage/lecturer_manage.action";		
	}                   
	  
	
}










