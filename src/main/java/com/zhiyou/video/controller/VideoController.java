package com.zhiyou.video.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou.video.model.Course;
import com.zhiyou.video.model.Speaker;
import com.zhiyou.video.model.Video;
import com.zhiyou.video.service.courseService;
import com.zhiyou.video.service.lecturerService;
import com.zhiyou.video.service.videoService;
import com.zhiyou.video.utils.Page;
@RequestMapping("/admin")
@Controller
public class VideoController {

	@Autowired
	@Qualifier("videoServiceImpl")
	videoService vs;
	@Autowired
	courseService cs;
	@Autowired
	lecturerService ls;
	//@RequestParam(defaultValue="null")String videoTitle
	
	@RequestMapping("/video_manage/video_list.action")
	public String videoList(HttpServletRequest request,HttpServletResponse response,
			Video video,@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="")String videoTitle) {		
	    video.setVideoTitle(videoTitle);
		//回现
	    request.setAttribute("video", video);
		//查询主讲人
		List<Speaker> findAllSpeaker = ls.findAllSpeaker();
		request.setAttribute("findAllSpeaker", findAllSpeaker);
		//查询课程
		List<Course> findAllCourse = cs.findAllCourse();
		request.setAttribute("findAllCoursr", findAllCourse);
		//total查询总条数	
		Page<Video> pageinfo = vs.findPageVideo(video,page);
		request.setAttribute("page",pageinfo);
		return "/video_manage/video_list";
	}
	
	//跳转到添加课程
	@RequestMapping("/video_manage/video_add.action")
	public String skipAddVideo(HttpServletRequest request,HttpServletResponse response) {
		List<Speaker> findAllSpeaker = ls.findAllSpeaker();
		request.setAttribute("findAllSpeaker", findAllSpeaker);
		List<Course> findAllCourse = cs.findAllCourse();
		request.setAttribute("findAllCoursr", findAllCourse);
		return "/video_manage/video_add";
	}
	//添加视频
	@RequestMapping("/video_manage/addvideo.action")
	public String addVideo(HttpServletRequest request,HttpServletResponse response,Video video) {
		vs.addVideo(video);
		return "redirect:/admin/video_manage/video_list.action";
	}
	
	//插叙将要编辑的课程
	@RequestMapping("/video_manage/find_video_edit.action")
	public String findVideo(HttpServletRequest request,HttpServletResponse response,Integer id) {
		List<Speaker> findAllSpeaker = ls.findAllSpeaker();
		request.setAttribute("findAllSpeaker", findAllSpeaker);
		List<Course> findAllCourse = cs.findAllCourse();
		request.setAttribute("findAllCoursr", findAllCourse);
		Video video = vs.findByIdVideo(id);
		request.setAttribute("video", video);
		return "/video_manage/video_edit";
	}
	
	//更新video  /video_manage/updatevideo.action
	@RequestMapping("/video_manage/updatevideo.action")
	public String updateVideo(HttpServletRequest request,HttpServletResponse response,Video video) {
           vs.updateVideo(video);
		return "forward:/admin/video_manage/video_list.action";
	}
	//通过id删除
	@RequestMapping("/video_manage/delete_video.action")
	public String deleteVideo(HttpServletRequest request,HttpServletResponse response,Integer id) {
          vs.deleteVideoById(id);
		return "forward:/admin/video_manage/video_list.action";
	}
	//批量删除                                video_manage/delete.action 
	@RequestMapping("/video_manage/delete.action")
	public String deleteAll(int[] id){
		System.out.println("测试第一道控制针错误"+id);
		vs.deleteVideos(id);
		//重定向 如果		
		return "redirect:/admin/video_manage/video_list.action";
	}
}
