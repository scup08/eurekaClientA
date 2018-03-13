package com.lzh.eurekaClientA.pool;

import java.sql.Connection;
import java.util.List;

public class DBConfig {
	
	private String driverName;  //驱动
	private String url;   //连接地址
	private String userName;   //用户名
	private String password;   //密码
	
	private Integer maxFreeConnNo = 10;  //空闲池    最大连接数
	private Integer minFreeConnNo = 1;  //空闲池， 最小连接数
	private Integer maxActiveConnNo = 20 ;  //允许活动的最大连接数
	private Integer initConnNo = 4; //初始化连接数
	
	private long repeatConnTime = 1000; //重新连接时长    1秒
	private long connTimeOut = 1000*60*20;  //超时时间    20分钟
	
	public DBConfig(){
		
	}
	public DBConfig(String driverName,String url,String userName,String password){
		this.driverName = driverName;
		this.url = url;
		this.userName = userName;
		this.password = password;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getInitConnNo() {
		return initConnNo;
	}
	public void setInitConnNo(Integer initConnNo) {
		this.initConnNo = initConnNo;
	}
	public long getRepeatConnTime() {
		return repeatConnTime;
	}
	public void setRepeatConnTime(long repeatConnTime) {
		this.repeatConnTime = repeatConnTime;
	}
	public long getConnTimeOut() {
		return connTimeOut;
	}
	public void setConnTimeOut(long connTimeOut) {
		this.connTimeOut = connTimeOut;
	}
	public Integer getMaxFreeConnNo() {
		return maxFreeConnNo;
	}
	public void setMaxFreeConnNo(Integer maxFreeConnNo) {
		this.maxFreeConnNo = maxFreeConnNo;
	}
	public Integer getMinFreeConnNo() {
		return minFreeConnNo;
	}
	public void setMinFreeConnNo(Integer minFreeConnNo) {
		this.minFreeConnNo = minFreeConnNo;
	}
	public Integer getMaxActiveConnNo() {
		return maxActiveConnNo;
	}
	public void setMaxActiveConnNo(Integer maxActiveConnNo) {
		this.maxActiveConnNo = maxActiveConnNo;
	}
}
