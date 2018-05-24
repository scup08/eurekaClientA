package com.lzh.eurekaClientA.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzh.eurekaClientA.service.ITestService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(value="/transaction")
public class TestTransaction {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(TestTransaction.class);
	
	@Autowired
	private ITestService testService;
	
	
	@RequestMapping(value="/addTestInfo")
	public void addTestInfo(){
		
		
		testService.addTestInfoA();
		testService.addTestInfoB();
		testService.addTestInfoC();
	}
}
