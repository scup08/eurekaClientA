package com.lzh.eurekaClientA.service;

public interface ITransationService {

	/**
	 * 测试事务传播属性
	 */
	public void testTransation();
	
	
	/**
	 * 测试分布式事务传播属性
	 */
	public void disTransation();
}
