package com.zhiyou.video.model;

import java.util.Date;

public class Video {
    private Integer id;

    private String videoTitle;

    private Integer speakerId;

    private Integer courseId;

    private Integer videoLength;
    
    private String videoLengthStr;

    private String videoImageUrl;

    private String videoUrl;

    private String videoDescr;

    private Date insertTime;

    private Date updateTime;

    private Integer videoPlayTimes;
    
    private String speakerName;
    
    private String courseName;
    
    private int page;
    
    

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getSpeakerName() {
		return speakerName;
	}

	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
		 /*if(speakerName == null){
	        	this.speakerName = "";
	        }*/
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
		/*if(courseName == null){
        	this.courseName = "";
        }*/
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
    	
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
      
    }

    public Integer getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Integer speakerId) {
        this.speakerId = speakerId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(Integer videoLength) {
        this.videoLength = videoLength;
    }

    public String getVideoImageUrl() {
        return videoImageUrl;
    }

    public void setVideoImageUrl(String videoImageUrl) {
        this.videoImageUrl = videoImageUrl == null ? null : videoImageUrl.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getVideoDescr() {
        return videoDescr;
    }

    public void setVideoDescr(String videoDescr) {
        this.videoDescr = videoDescr == null ? null : videoDescr.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVideoPlayTimes() {
        return videoPlayTimes;
    }

    public void setVideoPlayTimes(Integer videoPlayTimes) {
        this.videoPlayTimes = videoPlayTimes;
    }

	public String getVideoLengthStr() {
		return videoLengthStr;
	}

	public void setVideoLengthStr(String videoLengthStr) {
		this.videoLengthStr = videoLengthStr;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", videoTitle=" + videoTitle + ", speakerId=" + speakerId + ", courseId=" + courseId
				+ ", videoLength=" + videoLength + ", videoLengthStr=" + videoLengthStr + ", videoImageUrl="
				+ videoImageUrl + ", videoUrl=" + videoUrl + ", videoDescr=" + videoDescr + ", insertTime=" + insertTime
				+ ", updateTime=" + updateTime + ", videoPlayTimes=" + videoPlayTimes + ", speakerName=" + speakerName
				+ ", courseName=" + courseName + ", page=" + page + "]";
	}
	
    
}