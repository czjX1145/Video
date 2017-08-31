package com.zhiyou.video.service;

import java.util.List;

import com.zhiyou.video.model.Course;
import com.zhiyou.video.model.Subject;

public interface courseService {

	List<Course> findAllCourse();

	void addCoures(Course course);

	Course findCourseById(int id);

	void updateCoures(Course course);

	void deleteCoures(int id);

	List<Course> findCourseByExample(Course course);

		
}
