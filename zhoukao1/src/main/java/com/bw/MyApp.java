package com.bw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.bw.mapper")
//@ComponentScan("")
public class MyApp {

	public static void main(String[] args) {
		
		SpringApplication.run(MyApp.class, args);

	}

}
