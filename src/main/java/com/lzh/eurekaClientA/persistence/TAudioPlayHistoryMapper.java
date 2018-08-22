package com.lzh.eurekaClientA.persistence;

import java.util.Map;

import com.lzh.common.annotation.MyBatisRepository;
import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.entity.TAudioPlayHistory;

@MyBatisRepository
public interface TAudioPlayHistoryMapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TAudioPlayHistory record);

    int insertSelective(TAudioPlayHistory record);

    TAudioPlayHistory selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TAudioPlayHistory record);

    int updateByPrimaryKey(TAudioPlayHistory record);
    
    TAudioPlayHistory findPlayHistory(Map map);
}