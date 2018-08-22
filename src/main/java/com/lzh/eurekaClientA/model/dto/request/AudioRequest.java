package com.lzh.eurekaClientA.model.dto.request;

import javax.validation.constraints.NotNull;

import com.lzh.common.model.dto.request.RestfulRequest;

/**
 * @author 
 */
public class AudioRequest extends RestfulRequest {

    private static final long serialVersionUID = -3286520204644035655L;

    private Integer userId;
    
    @NotNull
    private Integer audioId;
    

	public AudioRequest() {
		super();
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getAudioId() {
		return audioId;
	}


	public void setAudioId(Integer audioId) {
		this.audioId = audioId;
	}

}
