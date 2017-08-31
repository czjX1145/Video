package com.zhiyou.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.zhiyou.video.mapper.VideoMapper;
import com.zhiyou.video.model.Course;
import com.zhiyou.video.model.Video;
import com.zhiyou.video.model.VideoExample;
import com.zhiyou.video.model.VideoExample.Criteria;
import com.zhiyou.video.service.videoService;
import com.zhiyou.video.utils.Page;

@Service
public class videoServiceImpl implements videoService {

	@Autowired
	VideoMapper vm;
	
	@Override
	public List<Video> findAllVideo() {
		List<Video> videoList = vm.selecAllVideo();		
		return videoList;
	}

	//添加数据
	@Override
	public void addVideo(Video video) {
		vm.insert(video);
	}
    //按id查询
	@Override
	public Video findByIdVideo(Integer id) {
		Video video = vm.selectByPrimaryKey(id);
		return video;
	}
    //更新数据
	@Override
	public void updateVideo(Video video) {
		 int i = vm.updateByPrimaryKey(video);
		
	}
    //通过id删除Video
	@Override
	public void deleteVideoById(Integer id) {
		vm.deleteByPrimaryKey(id);
		
	}
    //分页
	@Override
	public Page<Video> findPageVideo(Video video,Integer page) {
		
		System.out.println(vm.selecPageAll(video)); 
		Page<Video> pageInfo = new Page<>();
		video.setPage((page-1)*5);
		pageInfo.setTotal(vm.selectPageAllVideo(video));
		pageInfo.setRows(vm.selecPageAll(video));
		pageInfo.setPage(page);
		pageInfo.setSize(5);		 
		return pageInfo;
	}

	@Override
	public void deleteVideos(int[] id) {
		System.out.println("测试空指针"+id);
		for (int i : id) {
			vm.deleteByPrimaryKey(i);
		}		
	}

	@Override
	public List<Video> findVideoByExample(Integer id) {
		VideoExample example = new VideoExample(); 
		Criteria criteria = example.createCriteria();
		criteria.andCourseIdEqualTo(id);
		List<Video> list = vm.selectByExample(example);		
		return list;
	}

	// 播放数量加一
	@Override
	public void updateVideoState(int videoId) {
		Video video = vm.selectByPrimaryKey(videoId);
		Integer times = video.getVideoPlayTimes();
		video.setVideoPlayTimes(times+1);
		vm.updateByPrimaryKey(video);
	}
    //查询videoList 包含 speakerName
	@Override
	public List<Video> findVideoById(Integer courseId) {
        List<Video> list = vm.selectVideoSpeaker(courseId);
		return null;
	}
	
    // 查video speakerName
	@Override
	public List<Video> findVideoById2(Integer courseId) {
        List<Video> list = vm.selectVideo(courseId);
        System.out.println("service层"+"-------"+list);
		return list;
	}

}





