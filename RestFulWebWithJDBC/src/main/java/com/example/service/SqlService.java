package com.example.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.util.JdbcConnector;
import com.example.entity.ScoreSheet;

@Service
public class SqlService {

	public ArrayList<ScoreSheet> getAll() throws SQLException {
		Connection connection = new JdbcConnector().getConnection();
		Statement statement = connection.createStatement();
		String sql = "select * from movies";
		ResultSet resultSet = statement.executeQuery(sql);

		ArrayList<ScoreSheet> resultList = new ArrayList<>();
		while (resultSet.next()) {
			ScoreSheet scoreSheet = new ScoreSheet(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getDouble(4));

			resultList.add(scoreSheet);
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
		return resultList;
	}

	public ArrayList<ScoreSheet> getScoreSheetByCondition(String condtionType, String value) throws SQLException{
		
		Connection connection = new JdbcConnector().getConnection();
		Statement statement = connection.createStatement();
		String sql = "select * from movies where " + condtionType + " = \"" + value + "\"";
		System.out.println("sql : " + sql);
		ResultSet resultSet = statement.executeQuery(sql);
		
		ArrayList<ScoreSheet> resultList = new ArrayList<ScoreSheet>();
		while(resultSet.next()) {
			resultList.add(new ScoreSheet(resultSet.getInt(1), resultSet.getString(2), 
					resultSet.getString(3), resultSet.getDouble(4)));
		}

		resultSet.close();
		statement.close();
		connection.close();
		
		return resultList;
	}
	
	public boolean insert(int id, String name, String info, double score) throws SQLException {

		Connection connection = new JdbcConnector().getConnection();
		Statement statement = connection.createStatement();
		String sql = "insert into movies(id, name, info, score) values(" + id + ",'" + name + "','" + info + "',"
				+ score + ")";

		boolean result = (statement.executeUpdate(sql) == 1) ? true : false;
		
		statement.close();
		connection.close();
		
		return result;
	}

	public boolean update(int id, String name, String info, double score) throws SQLException {

		Connection connection = new JdbcConnector().getConnection();
		Statement statement = connection.createStatement();
		String sql = "update movies set name = '" + name + "', info = '" + info + "', score = " + score + "where id = "
				+ id;
		
		boolean result = (statement.executeUpdate(sql) == 1) ? true : false;
		
		statement.close();
		connection.close();
		
		return result;
	}

	public boolean delete(int id) throws SQLException {

		Connection connection = new JdbcConnector().getConnection();
		Statement statement = connection.createStatement();
		String sql = "delete from movies where id = " + id;

		boolean result = (statement.executeUpdate(sql) == 1) ? true : false;
		
		statement.close();
		connection.close();
		
		return result;
	}

	public ScoreSheet getScoreSheetById(int id) throws SQLException {
		Connection connection = new JdbcConnector().getConnection();
		Statement statement = connection.createStatement();
		String sql = "select * from movies where id = " + id;
		ResultSet resultSet = statement.executeQuery(sql);
		ScoreSheet result = null;
		
		while (resultSet.next()) {
			result = new ScoreSheet(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getDouble(4));
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
		return (result != null) ? result : new ScoreSheet();
	}
}
