package com.zhiyou.video.service;

import java.util.List;

import com.zhiyou.video.model.Subject;

public interface subjectService {

	List<Subject> findAllSubject();

	Subject findSubjectById(int subjectId);
}
