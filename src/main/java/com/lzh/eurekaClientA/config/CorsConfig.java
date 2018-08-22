package com.lzh.eurekaClientA.config;

import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.web.cors.CorsConfiguration;  
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;  
import org.springframework.web.filter.CorsFilter;  
  
@Configuration  
public class CorsConfig {  
    private CorsConfiguration buildConfig() {  
        CorsConfiguration corsConfiguration = new CorsConfiguration();  
        corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
        corsConfiguration.addAllowedHeader("*"); // 2允许任何头
        corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等） 
        
        //response.addHeader("content-type", "application:json;charset=utf8");// Json数据格式
//		// 采用utf-8字符集
		//response.addHeader("Access-Control-Allow-Origin", "*");// 解决跨域问题
		//response.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");// Method设置为Post
		//response.addHeader("Access-Control-Allow-Headers","x-requested-with,content-type");// x-requested-with为XMLHttpRequest为ajax请求
        return corsConfiguration;  
    }  
  
    @Bean  
    public CorsFilter corsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        source.registerCorsConfiguration("/**", buildConfig()); // 4  
        return new CorsFilter(source);  
    }  
} 