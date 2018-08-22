package com.lzh.eurekaClientA.persistence;

import java.util.List;
import java.util.Map;

import com.lzh.common.annotation.MyBatisRepository;
import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.entity.TTestAudio;

@MyBatisRepository
public interface TTestAudioMapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TTestAudio record);

    int insertSelective(TTestAudio record);

    TTestAudio selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TTestAudio record);

    int updateByPrimaryKey(TTestAudio record);
    
    List<TTestAudio> findAudioListByMap(Map map);
    
}