package com.lzh.eurekaClientA.persistence;

import com.lzh.common.annotation.MyBatisRepository;
import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.entity.TAudioRecommend1;

@MyBatisRepository
public interface TAudioRecommend1Mapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TAudioRecommend1 record);

    int insertSelective(TAudioRecommend1 record);

    TAudioRecommend1 selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TAudioRecommend1 record);

    int updateByPrimaryKey(TAudioRecommend1 record);
}