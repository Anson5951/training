package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.util.JdbcConnector;
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
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 50; i++) {
			try {
				System.out.println("index : " + i);
				Connection connection = new JdbcConnector(properties).getConnection();
				Statement statement = connection.createStatement();
				String sql = "select * from movies where id = " + (i % 10);
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					System.out.println(i + " : " + resultSet.getString(1) + "," + resultSet.getString(2) + ","
							+ resultSet.getString(3) + "," + resultSet.getString(4));
				}
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		long duration = System.currentTimeMillis() - startTime;
		long minute = duration / (60 * 1000);
		duration -= (minute * 60 * 1000);
		long second = duration / 1000;
		long millsecond = duration % 1000;
		System.out.println("time : " + minute + " : " + second + "." + millsecond);
	}
	
	

}
