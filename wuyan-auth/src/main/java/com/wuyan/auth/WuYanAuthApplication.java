package com.wuyan.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wuyan
 * @since v1
 */
@SpringBootApplication
@MapperScan("com.wuyan.auth.**.mapper")
public class WuYanAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(WuYanAuthApplication.class, args);
	}

}
