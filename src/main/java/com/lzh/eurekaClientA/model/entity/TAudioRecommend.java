package com.lzh.eurekaClientA.model.entity;

import org.joda.time.DateTime;

public class TAudioRecommend {
	private Long uuid;

    private Long audioId;
    
    private Integer recommendLevel;
    
    private Integer randomNo;
    
    private DateTime createTime;

    public TAudioRecommend(){}
    
    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getAudioId() {
        return audioId;
    }

    public void setAudioId(Long audioId) {
        this.audioId = audioId;
    }

	public Integer getRecommendLevel() {
		return recommendLevel;
	}

	public void setRecommendLevel(Integer recommendLevel) {
		this.recommendLevel = recommendLevel;
	}

	public Integer getRandomNo() {
		return randomNo;
	}

	public void setRandomNo(Integer randomNo) {
		this.randomNo = randomNo;
	}

	public DateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(DateTime createTime) {
		this.createTime = createTime;
	}
    
}
