package com.lzh.eurekaClientA.persistence;

import com.lzh.common.persistence.CrudMapper;
import com.lzh.eurekaClientA.model.entity.TTestUser;

public interface TTestUserMapper extends CrudMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TTestUser record);

    int insertSelective(TTestUser record);

    TTestUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TTestUser record);

    int updateByPrimaryKey(TTestUser record);
}