package com.lzh.eurekaClientA.persistence;

import com.lzh.common.annotation.MyBatisRepository;
import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.entity.TAudioRecommend7;

@MyBatisRepository
public interface TAudioRecommend7Mapper extends CrudMapper {
    int deleteByPrimaryKey(Long uuid);

    int insert(TAudioRecommend7 record);

    int insertSelective(TAudioRecommend7 record);

    TAudioRecommend7 selectByPrimaryKey(Long uuid);

    int updateByPrimaryKeySelective(TAudioRecommend7 record);

    int updateByPrimaryKey(TAudioRecommend7 record);
}