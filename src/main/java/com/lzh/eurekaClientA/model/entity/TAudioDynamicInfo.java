package com.lzh.eurekaClientA.model.entity;

public class TAudioDynamicInfo {
    private Long uuid;

    private Long audioId;
    
    private Integer pushNo;

    private Integer pushLevel;

    private String pushFlag;

    private Integer playNo;

    private Integer appreciateNo;

    private Double appreciateRate;

    private Integer commentNo;

    private Double commentRate;

    private Integer forwardNo;

    private Double forwardRate;

    private Integer completeNo;

    private Double completeRate;
    
    public TAudioDynamicInfo(){}

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Integer getPushNo() {
        return pushNo;
    }

    public void setPushNo(Integer pushNo) {
        this.pushNo = pushNo;
    }

    public Integer getPushLevel() {
        return pushLevel;
    }

    public void setPushLevel(Integer pushLevel) {
        this.pushLevel = pushLevel;
    }

    public String getPushFlag() {
        return pushFlag;
    }

    public void setPushFlag(String pushFlag) {
        this.pushFlag = pushFlag == null ? null : pushFlag.trim();
    }

    public Integer getPlayNo() {
        return playNo;
    }

    public void setPlayNo(Integer playNo) {
        this.playNo = playNo;
    }

    public Integer getAppreciateNo() {
        return appreciateNo;
    }

    public void setAppreciateNo(Integer appreciateNo) {
        this.appreciateNo = appreciateNo;
    }

    public Double getAppreciateRate() {
        return appreciateRate;
    }

    public void setAppreciateRate(Double appreciateRate) {
        this.appreciateRate = appreciateRate;
    }

    public Integer getCommentNo() {
        return commentNo;
    }

    public void setCommentNo(Integer commentNo) {
        this.commentNo = commentNo;
    }

    public Double getCommentRate() {
        return commentRate;
    }

    public void setCommentRate(Double commentRate) {
        this.commentRate = commentRate;
    }

    public Integer getForwardNo() {
        return forwardNo;
    }

    public void setForwardNo(Integer forwardNo) {
        this.forwardNo = forwardNo;
    }

    public Double getForwardRate() {
        return forwardRate;
    }

    public void setForwardRate(Double forwardRate) {
        this.forwardRate = forwardRate;
    }

    public Integer getCompleteNo() {
        return completeNo;
    }

    public void setCompleteNo(Integer completeNo) {
        this.completeNo = completeNo;
    }

    public Double getCompleteRate() {
        return completeRate;
    }

    public void setCompleteRate(Double completeRate) {
        this.completeRate = completeRate;
    }

	public Long getAudioId() {
		return audioId;
	}

	public void setAudioId(Long audioId) {
		this.audioId = audioId;
	}
    
}