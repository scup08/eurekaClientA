package com.lzh.eurekaClientA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzh.eurekaClientA.feignService.TestBService;

@RestController
@RequestMapping(value="/testa")
public class TestA {
	
	@Autowired
	private TestBService testBService;
	
	
	@RequestMapping(value="/showName")
	public String showName(String name){
		
		String tr = testBService.getBName(" ddddd "+name);
		
		return " mynameis ------------------"+ name +" ++++++++++ " + tr;
	}
}
