package com.lzh.eurekaClientA.persistence;

import com.lzh.common.annotation.MyBatisRepository;
import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.entity.TAudioRecommend4;

@MyBatisRepository
public interface TAudioRecommend4Mapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TAudioRecommend4 record);

    int insertSelective(TAudioRecommend4 record);

    TAudioRecommend4 selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TAudioRecommend4 record);

    int updateByPrimaryKey(TAudioRecommend4 record);
}