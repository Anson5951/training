package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnector {

	public Connection connection = null;
	
	public JdbcConnector(Properties properties) {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://" + properties.getHosts() + ":" + properties.getPorts() + "/" + properties.getDatabaseName();
			connection = DriverManager.getConnection(url, properties.getUserName(), properties.getPassword());

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {

		return connection;
	}
}
