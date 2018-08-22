package com.lzh.eurekaClientA.model.dto;

/**
 * @author 
 */
public class AudioAvailableDto  {

	private Integer coun;
	private Integer randomNo;
	private Integer maxId;
	private Integer minId;
	
	public AudioAvailableDto(){}

	public Integer getCoun() {
		return coun;
	}

	public void setCoun(Integer coun) {
		this.coun = coun;
	}

	public Integer getRandomNo() {
		return randomNo;
	}

	public void setRandomNo(Integer randomNo) {
		this.randomNo = randomNo;
	}

	public Integer getMaxId() {
		return maxId;
	}

	public void setMaxId(Integer maxId) {
		this.maxId = maxId;
	}

	public Integer getMinId() {
		return minId;
	}

	public void setMinId(Integer minId) {
		this.minId = minId;
	}
	

}
