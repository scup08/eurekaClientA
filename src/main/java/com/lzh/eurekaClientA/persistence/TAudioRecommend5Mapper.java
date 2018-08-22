package com.lzh.eurekaClientA.persistence;

import com.lzh.common.annotation.MyBatisRepository;
import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.entity.TAudioRecommend5;

@MyBatisRepository
public interface TAudioRecommend5Mapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TAudioRecommend5 record);

    int insertSelective(TAudioRecommend5 record);

    TAudioRecommend5 selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TAudioRecommend5 record);

    int updateByPrimaryKey(TAudioRecommend5 record);
}