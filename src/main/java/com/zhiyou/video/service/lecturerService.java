package com.zhiyou.video.service;

import java.util.List;

import com.zhiyou.video.model.Speaker;
import com.zhiyou.video.utils.Page;

public interface lecturerService {

	List<Speaker> findAllSpeaker();

	Page<Speaker> findPageSpeaker(String speakerName, String speakerJob, int page);

	void addSpeaker(Speaker speaker);

	Speaker findSpeakerById(int id);

	void updateSpeaker(Speaker speaker);

	void deleteSpeaker(int id);

	Speaker findSpeakerById2(Integer speakerId);

	
}
