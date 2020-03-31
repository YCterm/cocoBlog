package com.yc.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mapper接口
@MapperScan("com.yc.blog")
public class CocoBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CocoBlogApplication.class, args);
	}

}
