package com.lzh.eurekaClientA.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzh.eurekaClientA.feignService.AccountTestService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(value="/testb")
public class TestB {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(TestB.class);
	
	@Autowired
	private AccountTestService accountTestService;
	
	@RequestMapping(value="/showtest")
	public void showName1(){
//		logger.info("/testb+++++++++++++");
		accountTestService.testInfo("32101");
	}
}
