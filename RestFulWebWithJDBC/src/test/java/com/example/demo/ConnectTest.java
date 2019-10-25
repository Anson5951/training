package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.util.JdbcConnector;
import com.example.util.Properties;

@SpringBootTest
public class ConnectTest {

	@Autowired
	private Properties properties;

	static List<Integer> currentConnections = new CopyOnWriteArrayList<>();

	@Test
	void contextLoads() {
		for (int x = 0; x < 5; x++) {
			long startTime = System.currentTimeMillis();
			BasicDataSource basicDataSource = new BasicDataSource();
			System.out.println("Max connection : " + basicDataSource.getMaxActive());
			
			IntStream.range(1, 50).parallel().forEach(i -> {
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				currentConnections.add(new Integer(i));
				try {
					System.out.println(currentConnections);
					connection = new JdbcConnector(properties).getConnection();
					statement = connection.createStatement();
					String sql = "select * from movies where id = " + (i % 10);
					resultSet = statement.executeQuery(sql);
					while (resultSet.next()) {
						String result = (i + " : " + resultSet.getString(1) + "," + resultSet.getString(2) + ","
								+ resultSet.getString(3) + "," + resultSet.getString(4));
					}
					resultSet.close();
					statement.close();
					connection.close();
					currentConnections.remove(new Integer(i));
				} catch (Exception e) {
					e.printStackTrace();
				}

			});
			long duration = System.currentTimeMillis() - startTime;
			long minute = duration / (60 * 1000);
			duration -= (minute * 60 * 1000);
			long second = duration / 1000;
			long millsecond = duration % 1000;
			System.out.println(x + " : " + minute + " : " + second + "." + millsecond);
		}
	}
}
