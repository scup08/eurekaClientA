package com.lzh.eurekaClientA.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzh.eurekaClientA.service.ITestService;
import com.lzh.eurekaClientA.service.ITransationService;

@Service
public class TransationServiceImpl implements ITransationService {

	@Autowired
	private ITestService testService;
	
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

}
