package com.lzh.eurekaClientA.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.lzh.eurekaClientA.model.entity.TTestAudio;

public interface IUploadService {

	/**
	 * 文件上传
	 */
	public TTestAudio saveFile(MultipartFile multipartFile) throws IOException;
	
	
	
}
