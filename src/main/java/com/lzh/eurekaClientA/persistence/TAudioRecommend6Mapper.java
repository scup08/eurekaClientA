package com.lzh.eurekaClientA.persistence;

import com.lzh.common.annotation.MyBatisRepository;
import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.entity.TAudioRecommend6;

@MyBatisRepository
public interface TAudioRecommend6Mapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TAudioRecommend6 record);

    int insertSelective(TAudioRecommend6 record);

    TAudioRecommend6 selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TAudioRecommend6 record);

    int updateByPrimaryKey(TAudioRecommend6 record);
}