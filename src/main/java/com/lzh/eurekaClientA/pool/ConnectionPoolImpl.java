package com.lzh.eurekaClientA.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ConnectionPoolImpl implements IConnectionPool {
	
	private DBConfig dbConfig ; 
	
	private Integer connNo = 0;  //当前创建的连接数
	
	private List<Connection> freeConnPool ;  //空闲连接池
	private List<Connection> activeConnPool;  //活动连接池
	
	private static ThreadLocal<Connection>  threadLocal = new ThreadLocal<Connection>();
	
	public ConnectionPoolImpl(DBConfig dbConfig){
		this.dbConfig = dbConfig;
		init();
		
	}
	
	private void init(){
		try {
			Class.forName(dbConfig.getDriverName());
			
			for(int i = 0 ; i < dbConfig.getInitConnNo() ; i++){
				Connection conn ;
				conn = newConnection();
				
				if(conn != null){
					freeConnPool.add(conn);
					connNo ++;
				}
			}
		} catch (ClassNotFoundException e) {
			// 数据库驱动找不到
			e.printStackTrace();
		}
		
	}
	
	private Connection newConnection(){
		Connection conn = null;
		try {
			Class.forName(dbConfig.getDriverName());
			
			conn = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUserName(), dbConfig.getPassword());
			
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动程序找不到");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("创建数据库连接异常");
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	
	@Override
	public Connection getCurrentConnection() {
		Connection conn = threadLocal.get();
		
		if(!isValid(conn)){
			conn = getConnection();
		}
		
		return conn;
	}
	
	@Override
	public Connection getConnection() {
		Connection conn = null ;
		try {
			//先判断是否超过最大连接数限制
			if(connNo < dbConfig.getMaxActiveConnNo()){
				if(freeConnPool.size()>0){
					conn = freeConnPool.get(0);
					
					if(conn != null){
						threadLocal.set(conn);
					}
					
					freeConnPool.remove(0);
				}
			}else{
				
				wait(dbConfig.getConnTimeOut());
				conn = 	getConnection();
			}
			
			if(isValid(conn)){
				activeConnPool.add(conn);
				connNo++;
			}
		} catch (InterruptedException e) {
			System.out.println("wait 异常");
			e.printStackTrace();
		}
		return conn;
	}
	
	@Override
	public void releaseConn(Connection conn) {
		if(isValid(conn) && freeConnPool.size()< dbConfig.getMaxFreeConnNo() ){
			freeConnPool.add(conn);
			activeConnPool.remove(conn);
//			connNo--;
			threadLocal.remove();
			//唤醒所有等待的线程去抢连接
			notifyAll();
		}
	}
	
	@Override
	public void destroy() {
		try {
			for(Connection conn : freeConnPool){
				if(isValid(conn)){
						conn.close();
				}
			}
			for(Connection conn : activeConnPool){
				if(isValid(conn)){
					conn.close();
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		connNo = 0;  
	}
	
	private boolean isValid(Connection conn){
		try {
			if(conn == null || conn.isClosed()){
				return false;
			}
		} catch (SQLException e) {
			// 
			System.out.println("连接异常");
			e.printStackTrace();
		}
		
		return true;
	}

	
}
