package com.lzh.eurekaClientA.persistence;

import com.lzh.common.annotation.MyBatisRepository;
import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.entity.TTest;

@MyBatisRepository
public interface TTestMapper extends CrudMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TTest record);

    int insertSelective(TTest record);

    TTest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TTest record);

    int updateByPrimaryKey(TTest record);
}