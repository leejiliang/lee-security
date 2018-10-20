package com.lee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: lee-security
 * @description: startclass
 * @author: Jiliang.Lee
 * @create: 2018-10-19 20:19
 **/
@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
