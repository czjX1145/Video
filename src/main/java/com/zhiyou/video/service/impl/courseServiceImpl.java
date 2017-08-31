package com.zhiyou.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.video.mapper.CourseMapper;
import com.zhiyou.video.model.Course;
import com.zhiyou.video.model.CourseExample;
import com.zhiyou.video.model.CourseExample.Criteria;
import com.zhiyou.video.model.Subject;
import com.zhiyou.video.service.courseService;
@Service
public class courseServiceImpl implements courseService{

	@Autowired
	CourseMapper cm;
	@Override
	public List<Course> findAllCourse() {
		List<Course> courselist = cm.selectAllCourse();
		return courselist;
	}
	@Override
	public void addCoures(Course course) {
		cm.insert(course);		
	}
	@Override
	public Course findCourseById(int id) {
		Course course = cm.selectByPrimaryKey(id);
		return course;
	}
	//按id更新数据
	@Override
	public void updateCoures(Course course) {
		cm.updateByPrimaryKeySelective(course);		
	}
	//按id删除数据
	@Override
	public void deleteCoures(int id) {
		cm.deleteByPrimaryKey(id);
		
	}
	//按条件查询Course 返回front
	@Override
	public List<Course> findCourseByExample(Course course) {
		CourseExample example = new CourseExample(); 
		Criteria criteria = example.createCriteria();
		//criteria.andEmailEqualTo(user.getEmail()).andPasswordEqualTo(user.getPassword());		
		criteria.andSubjectIdEqualTo(course.getSubjectId());
		List<Course> list = cm.selectByExample(example);
		return list;
	}
	
	

}






