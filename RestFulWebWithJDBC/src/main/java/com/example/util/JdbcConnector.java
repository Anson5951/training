package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JdbcConnector {

	public Connection connection = null;
	
	public JdbcConnector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://remotemysql.com:3306/DVph4FIxDe";
			connection = DriverManager.getConnection(url, "DVph4FIxDe", "g2lCZx7Bo1");
			System.out.println("connection is valid : " + connection.isValid(0));

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {

		return connection;
	}
}
