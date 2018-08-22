package com.lzh.eurekaClientA.service;

import java.util.List;
import java.util.Map;

import com.lzh.eurekaClientA.model.entity.TAudioRecommend;
import com.lzh.eurekaClientA.model.entity.TTestAudio;


public interface IAudioPoolService {
	
	/**
	 * 通过数量查询音频资源
	 */
	List<TTestAudio> findAudioListByNo(Map map);
	/**
	 * 将音频放入池中
	 */
	int putAudioInPool(TAudioRecommend tar);
	
}
