package com.zhiyou.video.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.video.model.Course;
import com.zhiyou.video.model.Subject;
import com.zhiyou.video.service.courseService;
import com.zhiyou.video.service.subjectService;

@RequestMapping("/admin")
@Controller
public class CourseController {

	@Autowired
	courseService cs;
	@Autowired
	subjectService ss;
	
	@RequestMapping("/course_manage/course_manage.action")
	public String couresList(HttpServletRequest request,HttpServletResponse response) {
		List<Course> courselist = cs.findAllCourse();
		request.getSession().setAttribute("courselist", courselist);
		return "/course_manage/course_manage";
	}
	///跳转到添加数据的界面
	@RequestMapping("/course_manage/skip_course_add.action")
	public String coures(HttpServletRequest request,HttpServletResponse response) {	
		List<Subject> subjectlist = ss.findAllSubject();
		request.setAttribute("subjectlist", subjectlist);
		return "/course_manage/course_add";
	}
	//添加数据
	@RequestMapping("/course_manage/addcourse.action")
	public String addcoures(HttpServletRequest request,HttpServletResponse response,Course course) {
		cs.addCoures(course);
		return "forward:/admin/course_manage/course_manage.action";
	}
	//跳转到要编辑的界面
	@RequestMapping("course_manage/skip_course_edit.action")
	public String skipEditCoures(HttpServletRequest request,HttpServletResponse response,int id) {
		//查询subject
		List<Subject> subjectlist = ss.findAllSubject();
		request.setAttribute("subjectlist", subjectlist);
		//按id查询要修改的数据
		Course course = cs.findCourseById(id);
		request.setAttribute("courseById", course);
		return "/course_manage/course_edit";
	}
	//按id更新数据
	@RequestMapping("course_manage/updatecourse.action")
	public String updateCoures(HttpServletRequest request,HttpServletResponse response,Course course) {
		cs.updateCoures(course);
		return "forward:/admin/course_manage/course_manage.action";
	}
	
	//按id删除数据
	@RequestMapping("course_manage/deletecourse.action")
	public String deleteCoures(HttpServletRequest request,HttpServletResponse response,int id) {
		cs.deleteCoures(id);
		return "redirect:/admin/course_manage/course_manage.action";
	}
	
	
	
	
}
