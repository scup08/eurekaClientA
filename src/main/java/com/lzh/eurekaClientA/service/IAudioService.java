package com.lzh.eurekaClientA.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.lzh.common.model.dto.fastdfs.FastDto;
import com.lzh.eurekaClientA.model.entity.TTestAudio;


public interface IAudioService {
	
	/**
	 * 添加一条音频
	 */
	public int addAudio(TTestAudio testAudio);
	
	/**
	 * 上传音频并保存
	 * @throws IOException 
	 */
	public TTestAudio uploadAndSaveAudio(MultipartFile multipartFile,FastDto fastDto) throws IOException;

	/**
	 * findAudioListByMap
	 */
	public List<TTestAudio> findAudioListByMap(Map map);
	/**
	 * 添加播放记录
	 */
	public void addPalyEvent(Map map);
}
