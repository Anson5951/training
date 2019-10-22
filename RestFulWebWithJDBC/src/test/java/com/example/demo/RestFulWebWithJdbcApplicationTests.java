package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.util.Properties;


@SpringBootTest
class RestFulWebWithJdbcApplicationTests {

	@Autowired
	private Properties properties;
	
	@Value("#{11+2}")
	private int number;
	
	@Value("${remotedatabase.hosts}")
	private String hosts;
	
	@Test
	void contextLoads() {
		System.out.println("start test");
		System.out.println("hosts : " + hosts);
		System.out.println(properties.toString());
		System.out.println("number : " + number);
	}

}
