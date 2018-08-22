package com.lzh.eurekaClientA.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lzh.common.model.dto.response.ObjectCollectionResponse;
import com.lzh.eurekaClientA.model.dto.request.AudioRequest;
import com.lzh.eurekaClientA.model.entity.TTestAudio;
import com.lzh.eurekaClientA.service.IAudioDynamicInfoService;
import com.lzh.eurekaClientA.service.IAudioService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(value="/audio")
public class AudioController {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(AudioController.class);
	
	@Autowired
	private IAudioService audioService;
	
	
	@Autowired
	private IAudioDynamicInfoService audioDynamicInfoService;
	
	
	/**
	 * 获取音频列表
	 */
	@RequestMapping(value="/" ,method=RequestMethod.GET)
	public ObjectCollectionResponse<TTestAudio> getAudio(Integer userId , Integer isRandom){
		
		ObjectCollectionResponse<TTestAudio> rs = new ObjectCollectionResponse<TTestAudio>();
		
		Map map = new HashMap(8);
		map.put("userId", userId);
		map.put("isRandom", isRandom);
		List<TTestAudio> list = audioService.findAudioListByMap(map);
		
		rs.setDataSet(list);
		
		return rs;
	}
	
	/**
	 * 添加播放事件
	 * 
	 */
	@RequestMapping(value="/palyEvent" ,method=RequestMethod.POST )
	public void palyEvent(@RequestParam("userId") Integer userId,@RequestParam("audioId") Integer audioId){
		//1.添加到播放历史记录表
		
		Map map = new HashMap(8);
		map.put("userId", 1234);
		map.put("audioId", audioId);
		audioService.addPalyEvent(map);
		//2.播放量加1
		dynamicInfo(audioId , 2);
	}
	
	/**
	 * 更新音频动态信息
	 * type : 1-推送量，2-播放量，3-点赞量，4-评论量，5-转发量，6-完播量
	 */
	@RequestMapping(value="/dynamicInfo" ,method=RequestMethod.POST)
	public void dynamicInfo( Integer audioId , Integer type){
		
		//1.更新音频动态信息表
		
		Map map = new HashMap(8);
		map.put("audioId", audioId);
		map.put("type", type);
		audioDynamicInfoService.updateDynamicInfo(map);
		
	}
	
	/**
	 * 获取指定音频  (先不考虑)
	 */
//	@RequestMapping(value="/{audioId}" ,method=RequestMethod.GET)
//	public void getAudioById(){
//		audioService.getAudioById();
//	}
	
	/**
	 * 添加一条音频
	 */
//	@RequestMapping(value="/upload" ,method=RequestMethod.POST)
//	public void addAudio(@RequestBody TTestAudio testAudio){
//		audioService.addAudio(testAudio);
//	}
	
}
