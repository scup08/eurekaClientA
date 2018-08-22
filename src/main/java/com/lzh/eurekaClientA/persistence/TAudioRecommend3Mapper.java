package com.lzh.eurekaClientA.persistence;

import com.lzh.common.annotation.MyBatisRepository;
import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.entity.TAudioRecommend3;

@MyBatisRepository
public interface TAudioRecommend3Mapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TAudioRecommend3 record);

    int insertSelective(TAudioRecommend3 record);

    TAudioRecommend3 selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TAudioRecommend3 record);

    int updateByPrimaryKey(TAudioRecommend3 record);
}