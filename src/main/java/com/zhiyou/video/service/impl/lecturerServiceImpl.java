package com.zhiyou.video.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhiyou.video.mapper.SpeakerMapper;
import com.zhiyou.video.model.Speaker;
import com.zhiyou.video.service.lecturerService;
import com.zhiyou.video.utils.Page;

@Service
public class lecturerServiceImpl implements lecturerService {


	@Autowired
	SpeakerMapper sm;
	@Override
	public List<Speaker> findAllSpeaker() {
		List<Speaker> speakerList = sm.selectByExample(null);
		return speakerList;
	}
	//分页查询
	@Override
	public Page<Speaker> findPageSpeaker(String speakerName, String speakerJob, int page) {		
		Speaker speaker = new Speaker();
		speaker.setSpeakerName(speakerName);
		speaker.setSpeakerJob(speakerJob);
		speaker.setPage((page-1)*5);
		Page<Speaker> pageInfo = new Page<>();
		pageInfo.setTotal(sm.selectPageAllSpeaker(speaker));
		pageInfo.setRows(sm.selecPageAll(speaker));
		pageInfo.setPage(page);
		pageInfo.setSize(5);		 
		return pageInfo;
	}
	//添加speaker
	@Override
	public void addSpeaker(Speaker speaker) {
		sm.insert(speaker);
	}
	//按id查询
	@Override
	public Speaker findSpeakerById(int id) {
		Speaker speaker = sm.selectByPrimaryKey(id);
		return speaker;
	}
	//按id查询 返回对象不为空 内容可以为空
	@Override
	public Speaker findSpeakerById2(Integer speakerId) {
		Speaker speaker= sm.selectById(speakerId);
		if(speaker == null){
			speaker.setSpeakerName(null);
		}
		System.out.println("测试aaaaaaaaaaa"+speaker);
		return speaker;
	}
	//更新数据
	@Override
	public void updateSpeaker(Speaker speaker) {
		sm.updateByPrimaryKey(speaker);		
	}
	//按id删除
	@Override
	public void deleteSpeaker(int id) {
		sm.deleteByPrimaryKey(id);		
	}
	

}
