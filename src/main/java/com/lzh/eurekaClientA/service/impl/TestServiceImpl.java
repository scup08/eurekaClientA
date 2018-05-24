package com.lzh.eurekaClientA.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzh.eurekaClientA.model.entity.TTestUser;
import com.lzh.eurekaClientA.persistence.TTestUserMapper;
import com.lzh.eurekaClientA.service.ITestService;


@Service
public class TestServiceImpl implements ITestService {

	@Autowired
	private TTestUserMapper testUserMapper;
	
	@Override
	public int addTestInfoA() {
		TTestUser testUser = new TTestUser();
		testUser.setMobile("AAAA");
		int rs = testUserMapper.insert(testUser);
		return rs;
	}

	@Override
	public int addTestInfoB() {
		TTestUser testUser = new TTestUser();
		testUser.setMobile("BBBB");
		int rs = testUserMapper.insert(testUser);
		return rs;
	}

	@Override
	public int addTestInfoC() {
		TTestUser testUser = new TTestUser();
		testUser.setMobile("CCCC");
		int rs = testUserMapper.insert(testUser);
		return rs;
	}

}
