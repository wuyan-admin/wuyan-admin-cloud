package com.wuyan.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wuyan
 * @since v1
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.wuyan.auth.**.mapper")
public class WuYanAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(WuYanAuthApplication.class, args);
	}

}
