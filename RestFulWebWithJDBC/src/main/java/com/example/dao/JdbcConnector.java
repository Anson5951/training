package com.example.dao;

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
/*
 * 	public Connection connection = null;

	@Value("${remotedatabase.connect.hosts}")
	private String hosts;
	
	@Value("${remotedatabase.connect.databasename}")
	private String databaseName;
	
	@Value("${remotedatabase.connect.parameters}")
	private String parameters;
	
	@Value("${remotedatabase.connect.username}")
	private String username;
	
	@Value("${remotedatabase.connect.password}")
	private String password;
	

	public JdbcConnector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://" + hosts + "/" + databaseName + "?" + parameters;
			connection = DriverManager.getConnection(url, username, password);
			System.out.println(connection.isValid(0));

 */
	public Connection getConnection() {

		return connection;
	}
}
