package com.lzh.eurekaClientA;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.lzh.common.annotation.MyBatisRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.lzh.eurekaClientA","com.lzh.common.advice"})
@MapperScan(basePackages = "com.lzh.eurekaClientA.persistence", annotationClass = MyBatisRepository.class)
public class EurekaClientAApplication {

    public static void main(String[] args) {
    	ApplicationContext context =  SpringApplication.run(EurekaClientAApplication.class, args);
        
//        SpringApplication.run(EurekaClientAApplication.class,args);

//        Message msg = new Message("test",// topic
//                "test",// tag
//                "KKK",//key用于标识业务的唯一性
//                ("Hello RocketMQ !!!!!!!!!!" ).getBytes()// body 二进制字节数组
//        );
        
//        DefaultMQProducer defaultMQProducer = context.getBean(DefaultMQProducer.class);
//        Message msg = new Message("test",// topic
//                "test",// tag
////                "KKK",//key用于标识业务的唯一性
//                ("Hello RocketMQ !!!!!!!!!!" ).getBytes()// body 二进制字节数组
//        );
//        SendResult result;
//		try {
//			result = defaultMQProducer.send(msg);
//			System.out.println(result);
//		} catch (MQClientException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (RemotingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MQBrokerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
//        DefaultMQPushConsumer consumer = context.getBean(DefaultMQPushConsumer.class);
    }
}
