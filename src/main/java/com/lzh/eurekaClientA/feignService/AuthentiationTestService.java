package com.lzh.eurekaClientA.feignService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="authenticationservice")
public interface AuthentiationTestService {

	@RequestMapping(value="/authTest/testInfo",method=RequestMethod.POST)
	public void testInfo(@RequestParam(value = "aa")String aa);
}
