package com.lzh.eurekaClientA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzh.common.model.dto.response.ObjectCollectionResponse;
import com.lzh.common.model.entity.account.TAccountUser;
import com.lzh.eurekaClientA.feignService.TestBService;

@RestController
@RequestMapping(value="/testa")
public class TestA {
	
	@Autowired
	private TestBService testBService;
	
	
	@RequestMapping(value="/showName")
	public String showName(String name){
		
		
//		Map creds = new ObjectMapper().readValue("",  Map.class);
		ObjectCollectionResponse<TAccountUser> tr = testBService.getBName();
//		return "";
		return " mynameis ------------------"+ tr.toString();
	}
}
