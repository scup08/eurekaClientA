package com.lzh.eurekaClientA.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzh.common.model.dto.response.ObjectCollectionResponse;
import com.lzh.common.model.entity.account.TAccountUser;
import com.lzh.eurekaClientA.feignService.TestBService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(value="/testb")
public class TestB {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(TestB.class);
	
	@Autowired
	private TestBService testBService;
	
	@Value("${test.str.name}")
	private String str1;
	
	@RequestMapping(value="/showtest")
	public void showName1(){
		logger.info("/testb+++++++++++++"+str1);
	}
}
