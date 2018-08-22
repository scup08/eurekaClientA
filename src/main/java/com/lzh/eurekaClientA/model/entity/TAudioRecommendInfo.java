package com.lzh.eurekaClientA.model.entity;

public class TAudioRecommendInfo {
    private Long uuid;

    private String recommendName;

    private String recommendCode;

    private Integer recommendNo;

    private Integer recommendLevel;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getRecommendName() {
        return recommendName;
    }

    public void setRecommendName(String recommendName) {
        this.recommendName = recommendName == null ? null : recommendName.trim();
    }

    public String getRecommendCode() {
        return recommendCode;
    }

    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode == null ? null : recommendCode.trim();
    }

    public Integer getRecommendNo() {
        return recommendNo;
    }

    public void setRecommendNo(Integer recommendNo) {
        this.recommendNo = recommendNo;
    }

    public Integer getRecommendLevel() {
        return recommendLevel;
    }

    public void setRecommendLevel(Integer recommendLevel) {
        this.recommendLevel = recommendLevel;
    }
}