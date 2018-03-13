package com.lzh.eurekaClientA.feignService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="eurekaClientB")
public interface TestBService {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getBName(String name);
}
