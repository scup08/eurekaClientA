package com.lzh.eurekaClientA.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzh.eurekaClientA.model.entity.TAudioDynamicInfo;
import com.lzh.eurekaClientA.persistence.TAudioDynamicInfoMapper;
import com.lzh.eurekaClientA.service.IAudioDynamicInfoService;


@Service
public class AudioDynamicInfoServiceImpl implements IAudioDynamicInfoService {


	@Autowired
	private TAudioDynamicInfoMapper taudioDynamicInfoMapper;

	/**
	 * 
	 * 更新音频动态信息
	 * type : 1-推送量，2-播放量，3-点赞量，4-评论量，5-转发量，6-完播量
	 */
	@Override
	public void updateDynamicInfo(Map map) {
		
		TAudioDynamicInfo tadi = new TAudioDynamicInfo();
		
		tadi.setAudioId(new Long((int)map.get("audioId")));
		
		Map queryMap = new HashMap(8);
		queryMap.put("audioId", tadi.getAudioId());
		List<TAudioDynamicInfo> oldList = taudioDynamicInfoMapper.findDynamicInfo(queryMap);
		if(oldList.size()<1){
			return;
		}
		TAudioDynamicInfo old = oldList.get(0);
		
		int type = (int)map.get("type");
		//判断type
		if(type == 1){
			//1-推送量
			tadi.setPushNo(old.getPushNo()+1);
		}else if(type == 2){
			//2-播放量
			tadi.setPlayNo(old.getPlayNo()+1);
		}else if(type == 3){
			//3-点赞量
			tadi.setAppreciateNo(old.getAppreciateNo()+1);
			//计算点赞率
			Double ar =  new Double(tadi.getAppreciateNo())/new Double(old.getPlayNo());
			ar = (double)Math.round(ar*100)/100;
			tadi.setAppreciateRate(ar);
		}else if(type == 4){
			//4-评论量
			tadi.setCommentNo(old.getCommentNo()+1);
			//计算评论率
			Double ar =  new Double(tadi.getCommentNo())/new Double(old.getPlayNo());
			ar = (double)Math.round(ar*100)/100;
			tadi.setCommentRate(ar);
		}else if(type == 5){
			//5-转发量
			tadi.setForwardNo(old.getForwardNo()+1);
			//计算转发率
			Double ar =  new Double(tadi.getForwardNo())/new Double(old.getPlayNo());
			ar = (double)Math.round(ar*100)/100;
			tadi.setForwardRate(ar);
		}else if(type == 6){
			//6-完播量
			tadi.setCompleteNo(old.getCompleteNo()+1);
			//计算完播率
			Double ar =  new Double(tadi.getCompleteNo())/new Double(old.getPlayNo());
			ar = (double)Math.round(ar*100)/100;
			tadi.setCompleteRate(ar);
		}else{
			
		}
		
		taudioDynamicInfoMapper.updateByPrimaryKeySelective(tadi);
	}

	@Override
	public int addDynamicInfo(TAudioDynamicInfo tadi) {
		
		//处理
		if(tadi.getAppreciateNo() == null ){
			tadi.setAppreciateNo(0);
			tadi.setAppreciateRate(0.0);
		}
		if(tadi.getCommentNo() == null ){
			tadi.setCommentNo(0);
			tadi.setCommentRate(0.0);
		}
		if(tadi.getCompleteNo() == null ){
			tadi.setCompleteNo(0);
			tadi.setCompleteRate(0.0);
		}
		if(tadi.getForwardNo() == null ){
			tadi.setForwardNo(0);
			tadi.setForwardRate(0.0);
		}
		if(tadi.getPlayNo() == null ){
			tadi.setPlayNo(0);
		}
		if(tadi.getPushNo() == null ){
			tadi.setPushNo(0);
		}
		if(tadi.getPushFlag() == null){
			tadi.setPushFlag("0");
		}
		if(tadi.getPushLevel() == null){
			tadi.setPushLevel(1);
		}
		return taudioDynamicInfoMapper. insert(tadi);
	}

	
	
}
