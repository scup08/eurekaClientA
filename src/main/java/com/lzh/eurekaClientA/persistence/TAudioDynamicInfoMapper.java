package com.lzh.eurekaClientA.persistence;

import java.util.List;
import java.util.Map;

import com.lzh.common.annotation.MyBatisRepository;
import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.entity.TAudioDynamicInfo;

@MyBatisRepository
public interface TAudioDynamicInfoMapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TAudioDynamicInfo record);

    int insertSelective(TAudioDynamicInfo record);

    TAudioDynamicInfo selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TAudioDynamicInfo record);

    int updateByPrimaryKey(TAudioDynamicInfo record);
    
    List<TAudioDynamicInfo> findDynamicInfo(Map map);
    
}