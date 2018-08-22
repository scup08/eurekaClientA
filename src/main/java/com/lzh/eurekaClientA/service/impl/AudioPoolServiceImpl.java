package com.lzh.eurekaClientA.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzh.common.util.RandomUtil;
import com.lzh.eurekaClientA.model.dto.AudioAvailableDto;
import com.lzh.eurekaClientA.model.entity.TAudioRecommend;
import com.lzh.eurekaClientA.model.entity.TTestAudio;
import com.lzh.eurekaClientA.persistence.TAudioFollowRecommendMapper;
import com.lzh.eurekaClientA.service.IAudioPoolService;


@Service
public class AudioPoolServiceImpl implements IAudioPoolService {

	@Autowired
	private TAudioFollowRecommendMapper taudioFollowRecommendMapper;

	@Override
	public List<TTestAudio> findAudioListByNo(Map map) {
		
		List<TTestAudio> rs = new ArrayList<TTestAudio>();
		
		Map rsMap = new HashMap(16);
		
		int poolLevel = (int) map.get("poolLevel");
		int pageSize = (int) map.get("pageSize");
		int availableNo = 0;
		int queryNo = 0;
		
		Map queryMap = new HashMap(8);
		queryMap.put("tableName", "t_audio_recommend_"+poolLevel);
		
		List<AudioAvailableDto>  aadList = getAvailableNo(queryMap);
		if(aadList.size()<1){
			return rs;
		}
		
		Map<Integer,AudioAvailableDto> aadMap = new HashMap<Integer,AudioAvailableDto>(16);
		for(AudioAvailableDto aad :aadList){
			aadMap.put(aad.getRandomNo(), aad);
			availableNo= availableNo+aad.getCoun();
		}
		
		if(availableNo < pageSize){
			pageSize = availableNo;
		}
		
		while(rsMap.size()<pageSize && queryNo < 1000){
			queryNo++;
			//1.取随机数
			Integer randomNo = RandomUtil.getRandomInt(1, 10);
			if( aadMap.get(randomNo)!=null ){
				
				queryMap.put("randomNo", randomNo);
				
				Integer randomAudioId = RandomUtil.getRandomInt(aadMap.get(randomNo).getMinId(), aadMap.get(randomNo).getMaxId());
				
				//1-ASC   2-DESC
				Integer randomOrder = RandomUtil.getRandomInt(1, 2);
				if(randomOrder ==1 ){
					queryMap.put("randomOrder", "ASC");
					queryMap.put("minAudioId", randomAudioId);
				}else{
					queryMap.put("randomOrder", "DESC");
					queryMap.put("maxAudioId", randomAudioId);
				}
				TTestAudio tta = taudioFollowRecommendMapper.findAudioRandom(queryMap);
				if(tta != null){
					rsMap.put(tta.getUuid(), tta);
				}
			}
			
		}
		rs = new ArrayList<TTestAudio>(rsMap.values());
		return rs;
	}

	private List<AudioAvailableDto> getAvailableNo(Map map){
		
		return taudioFollowRecommendMapper.queryAvailableNo(map);
	}

	@Override
	public int putAudioInPool(TAudioRecommend tar) {
		Map addMap = new HashMap(8);
		Integer randomNo = RandomUtil.getRandomInt(1, 10);
		addMap.put("tableName", "t_audio_recommend_"+tar.getRecommendLevel());
		addMap.put("audioId",tar.getAudioId());
		addMap.put("randomNo",randomNo);
		return taudioFollowRecommendMapper.putAudioInPool(addMap);
	}
}
