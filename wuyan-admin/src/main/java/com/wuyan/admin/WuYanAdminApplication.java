package com.wuyan.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.wuyan.admin.**.mapper")
public class WuYanAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(WuYanAdminApplication.class, args);
	}

}
