package com.lzh.eurekaClientA.persistence;

import com.lzh.common.annotation.MyBatisRepository;
import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.entity.TAudioRecommendInfo;

@MyBatisRepository
public interface TAudioRecommendInfoMapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TAudioRecommendInfo record);

    int insertSelective(TAudioRecommendInfo record);

    TAudioRecommendInfo selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TAudioRecommendInfo record);

    int updateByPrimaryKey(TAudioRecommendInfo record);
}