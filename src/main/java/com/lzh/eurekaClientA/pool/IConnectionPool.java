package com.lzh.eurekaClientA.pool;

import java.sql.Connection;

/**
 * 连接池接口
 * @author XHLD-08
 *
 */
public interface IConnectionPool {

	/**
	 * 获取连接池
	 */
	public Connection getConnection();
	/**
	 * 获取当前连接池
	 */
	public Connection getCurrentConnection();
	/**
	 * 回收连接
	 */
	public void releaseConn(Connection conn);
	/**
	 * 销毁清空
	 */
	public void destroy();
	
}
