package com.lzh.eurekaClientA.persistence;

import java.util.List;
import java.util.Map;

import com.lzh.common.annotation.MyBatisRepository;
import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.dto.AudioAvailableDto;
import com.lzh.eurekaClientA.model.entity.TAudioFollowRecommend;
import com.lzh.eurekaClientA.model.entity.TTestAudio;

@MyBatisRepository
public interface TAudioFollowRecommendMapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TAudioFollowRecommend record);

    int insertSelective(TAudioFollowRecommend record);

    TAudioFollowRecommend selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TAudioFollowRecommend record);

    int updateByPrimaryKey(TAudioFollowRecommend record);
    /**
     * 随机查询一条
     * @param map
     * @return
     */
    TTestAudio findAudioRandom(Map map);
    
    /**
     * 查询资源池中可推荐数量
     * @param map
     * @return
     */
    List<AudioAvailableDto> queryAvailableNo(Map map);
    
    /**
     * 将音频放入库中
     * @param map
     */
    int putAudioInPool(Map map);
}