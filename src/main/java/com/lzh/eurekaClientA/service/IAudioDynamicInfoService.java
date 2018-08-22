package com.lzh.eurekaClientA.service;

import java.util.Map;

import com.lzh.eurekaClientA.model.entity.TAudioDynamicInfo;


public interface IAudioDynamicInfoService {
	/**
	 * 
	 * 更新音频动态信息
	 * type : 1-推送量，2-播放量，3-点赞量，4-评论量，5-转发量，6-完播量
	 */
	public void  updateDynamicInfo(Map map);
	
	/**
	 * 新增怎动态信息
	 * @return
	 */
	public int addDynamicInfo(TAudioDynamicInfo tadi);
	
}
