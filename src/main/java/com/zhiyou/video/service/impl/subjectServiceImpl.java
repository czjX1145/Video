package com.zhiyou.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.video.mapper.SubjectMapper;
import com.zhiyou.video.model.Subject;
import com.zhiyou.video.service.subjectService;

@Service
public class subjectServiceImpl implements subjectService {

	@Autowired
	SubjectMapper sm;
	//插叙所有subject
	@Override
	public List<Subject> findAllSubject() {
		List<Subject> list = sm.selectByExample(null);
		return list;
	}
	
	@Override
	public Subject findSubjectById(int subjectId) {
		Subject subject = sm.selectByPrimaryKey(subjectId);
		return subject;
	}

}
