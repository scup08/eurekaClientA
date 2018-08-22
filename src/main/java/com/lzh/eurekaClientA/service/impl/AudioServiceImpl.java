package com.lzh.eurekaClientA.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lzh.common.model.dto.fastdfs.FastDto;
import com.lzh.eurekaClientA.model.entity.TAudioDynamicInfo;
import com.lzh.eurekaClientA.model.entity.TAudioPlayHistory;
import com.lzh.eurekaClientA.model.entity.TAudioRecommend;
import com.lzh.eurekaClientA.model.entity.TTestAudio;
import com.lzh.eurekaClientA.persistence.TAudioPlayHistoryMapper;
import com.lzh.eurekaClientA.persistence.TTestAudioMapper;
import com.lzh.eurekaClientA.service.IAudioDynamicInfoService;
import com.lzh.eurekaClientA.service.IAudioPoolService;
import com.lzh.eurekaClientA.service.IAudioService;
import com.lzh.eurekaClientA.service.IUploadService;


@Service
public class AudioServiceImpl implements IAudioService {

	@Autowired
	private TTestAudioMapper ttestAudioMapper;
	
	@Autowired
	private IUploadService uploadService;
	
	@Autowired
	private IAudioPoolService audioPoolService;
	
	@Autowired
	private IAudioDynamicInfoService audioDynamicInfoService;

	@Autowired
	private TAudioPlayHistoryMapper taudioPlayHistoryMapper;

	@Override
	public int addAudio(TTestAudio testAudio) {
		int rs = ttestAudioMapper.insert(testAudio);
		return rs;
	}

	@Override
	public TTestAudio uploadAndSaveAudio(MultipartFile multipartFile ,FastDto fastDto) throws IOException {
		//将文件上传到文件服务器上
		TTestAudio rs = uploadService.saveFile(multipartFile);
		
		//新增音频记录
		if(fastDto.getFileSize()!=rs.getSize() ){
			System.out.println("fastDto.getFileSize() ===="+fastDto.getFileSize() );
			System.out.println("rs.getSize()===" + rs.getSize() );
		}
		rs.setDuration(fastDto.getDuration());
		addAudio(rs);
		
		//新增动态信息
		TAudioDynamicInfo tadi = new TAudioDynamicInfo();
		tadi.setAudioId(new Long(rs.getUuid()));
		audioDynamicInfoService.addDynamicInfo(tadi);
		
		//把音频放进池中
		TAudioRecommend tar = new TAudioRecommend();
		tar.setAudioId(rs.getUuid());
		tar.setRecommendLevel(1);
		audioPoolService.putAudioInPool(tar);
		//判断推荐数
		
		
		return rs;
	}

	@Override
	public List<TTestAudio> findAudioListByMap(Map map) {
		
		List<TTestAudio> rs = new  ArrayList<TTestAudio>();
		
		int isRandom = 0;	//0-随机，1-非随机
		int pageSize = 5; //每次查询数量
		int poolLevel = 7;
		
		if(isRandom == 0){
			
			//循环资源池，获取列表
			while(poolLevel>0){
				
				if(rs.size() < pageSize){
					//返回列表未满
					Map wmap = new HashMap(8);
					wmap.put("poolLevel", poolLevel);
					wmap.put("pageSize", pageSize-rs.size());
					List<TTestAudio> audioList = audioPoolService.findAudioListByNo(wmap);
					
					rs.addAll(audioList);
					
					poolLevel --;
				}else{
					poolLevel = 0;
				}
				
				
			}
			
		}else{
			//需要修改，未完善
			rs = ttestAudioMapper.findAudioListByMap(map);
		}
		
		return rs;
	}

	/**
	 * 添加播放记录
	 */
	@Override
	public void addPalyEvent(Map map) {
		//先查询有没有，有就不添加了
		//后续完善功能，添加播放日志详细表，每次播放都记录
		
		TAudioPlayHistory taph = taudioPlayHistoryMapper.findPlayHistory(map);
		
		if(taph == null){
			taph = new TAudioPlayHistory();
			taph.setAudioId(new Long((int)map.get("audioId")));
			taph.setPlayTime(new Date());
			taph.setUserId(new Long((int)map.get("userId")));
			taudioPlayHistoryMapper.insert(taph);
		}
	}
	
}
