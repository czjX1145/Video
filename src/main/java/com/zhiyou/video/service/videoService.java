package com.zhiyou.video.service;

import java.util.List;

import com.zhiyou.video.model.Video;
import com.zhiyou.video.utils.Page;

public interface videoService {

	List<Video> findAllVideo();

	void addVideo(Video video);

	Video findByIdVideo(Integer id);

	void updateVideo(Video video);

	void deleteVideoById(Integer id);

	Page<Video> findPageVideo(Video video,Integer page);

	void deleteVideos(int[] id);

	List<Video> findVideoByExample(Integer id);

	void updateVideoState(int videoId);

	List<Video> findVideoById(Integer courseId);

	List<Video> findVideoById2(Integer courseId);
 
	
}
