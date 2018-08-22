package com.lzh.eurekaClientA.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzh.eurekaClientA.feignService.AccountTestService;
import com.lzh.eurekaClientA.feignService.AuthentiationTestService;
import com.lzh.eurekaClientA.feignService.ZuulTestService;
import com.lzh.eurekaClientA.service.ITestService;
import com.lzh.eurekaClientA.service.ITransationService;

@Service
public class TransationServiceImpl implements ITransationService {

	@Autowired
	private ITestService testService;
	
	@Autowired
	private AccountTestService accountTestService;
	
	@Autowired
	private AuthentiationTestService authentiationTestService;
	
	@Autowired
	private ZuulTestService zuulTestService;
	
	@Override
	@Transactional
	public void testTransation() {
		
		
		
		try{
			System.out.println("1111111111111");
			int a = testService.addTestInfoA();
			System.out.println("222222222222222---" +a );
			a = testService.addTestInfoB();
			System.out.println("33333333333333---" +a );
			
		}catch(Exception e){
			int b = testService.addTestInfoC();
			System.out.println("444444444444---" +b );
			System.out.println("异常了");
		}
		
		System.out.println("5555555555555");
	}

	@Override
	@Transactional
	public void disTransation() {

		System.out.println("1111111111111");
		accountTestService.testInfo("1234");
		System.out.println("2222222222222");
		authentiationTestService.testInfo("4321");
		System.out.println("333333333333");
//		zuulTestService.testInfo("abcd");
//		System.out.println("4444444444444");
	}

}
