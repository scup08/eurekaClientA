package com.lzh.eurekaClientA.persistence;

import com.lzh.common.annotation.MyBatisRepository;
import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.entity.TAudioRecommend2;

@MyBatisRepository
public interface TAudioRecommend2Mapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TAudioRecommend2 record);

    int insertSelective(TAudioRecommend2 record);

    TAudioRecommend2 selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TAudioRecommend2 record);

    int updateByPrimaryKey(TAudioRecommend2 record);
}