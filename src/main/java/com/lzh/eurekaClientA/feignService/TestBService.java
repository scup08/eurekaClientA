package com.lzh.eurekaClientA.feignService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lzh.common.model.dto.response.ObjectCollectionResponse;
import com.lzh.common.model.entity.account.TAccountUser;

@FeignClient(name="account")
public interface TestBService {

	@RequestMapping(value="/api/v1/users",method=RequestMethod.GET)
	public ObjectCollectionResponse<TAccountUser> getBName();
}
