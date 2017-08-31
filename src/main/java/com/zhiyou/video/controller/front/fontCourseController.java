package com.zhiyou.video.controller.front;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zhiyou.video.model.Course;
import com.zhiyou.video.model.Speaker;
import com.zhiyou.video.model.Subject;
import com.zhiyou.video.model.Video;
import com.zhiyou.video.service.courseService;
import com.zhiyou.video.service.lecturerService;
import com.zhiyou.video.service.subjectService;
import com.zhiyou.video.service.videoService;

@RequestMapping("/videoResources")
@Controller
public class fontCourseController {

	@Autowired
	courseService cs;
	@Autowired
	lecturerService ls;
	@Autowired
	subjectService ss;
	@Autowired
	videoService vs;
	//课程管理
	@RequestMapping("/front/course/index.action")
	public String courseMessage(Course course,int subjectId,HttpServletRequest request) {	
		//查出subject
		request.getSession().setAttribute("subjectId", subjectId);
		Subject subject= ss.findSubjectById(subjectId);
		request.getSession().setAttribute("subject", subject);
		//查courses
		List<Course> courses = cs.findCourseByExample(course);
		for (Course list : courses) {	
		list.setVideoList(vs.findVideoByExample(list.getId()));					
		}		
		request.getSession().setAttribute("courses", courses);		
		
		return "/front/course/index";
	}
	//跳转到视频界面                  /front/video/index.action
	@RequestMapping("/front/video/index.action")
	public String courseMessage2(int videoId,int subjectId,HttpServletRequest request) {
		request.getSession().setAttribute("videoId", videoId);  
		return "/front/video/index";
	} 
	//视频                             
	@RequestMapping("/front/video/videoData.action")
	public String courseVideo(int videoId,HttpServletRequest request){
		
		//根据id查video
		Video video = vs.findByIdVideo(videoId);
		request.getSession().setAttribute("video", video);
		//根据video的speaker_id查speaker
		Speaker speaker = ls.findSpeakerById(video.getSpeakerId());
		request.getSession().setAttribute("speaker", speaker);
		
		List<Video> list = vs.findVideoById2(video.getCourseId());
		request.getSession().setAttribute("videoList", list);
		return "/front/video/content";
	}
	
	//更新播放次数
	@RequestMapping("/front/video/state.action")
	public void videoState(int videoId) {
		vs.updateVideoState(videoId);		
	}
	
	
}
