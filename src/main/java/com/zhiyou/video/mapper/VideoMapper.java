package com.zhiyou.video.mapper;

import com.zhiyou.video.model.Video;
import com.zhiyou.video.model.VideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

	List<Video> selecAllVideo();
    //条件查询总条数total
	int selectPageAllVideo(Video video);
    //分页查询
	List<Video> selecPageAll(Video video);

	List<Video> selectVideoSpeaker(Integer courseId);
	
	List<Video> selectVideo(Integer courseId);

}