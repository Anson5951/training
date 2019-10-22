package com.example.controller.rest;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.ScoreSheet;
import com.example.service.SqlService;

@RestController
@RequestMapping("/scoreSheet/movies")
public class MovieController {

	@Autowired
	private SqlService sqlService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ArrayList<ScoreSheet> getAll() throws SQLException {

		return sqlService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ScoreSheet getScoreSheetById(@PathVariable int id) throws SQLException {

		return sqlService.getScoreSheetById(id);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ArrayList<ScoreSheet> searchScoreSheetByCondition(@RequestParam(name = "conditiontype") String conditionType,
			@RequestParam String value) throws SQLException {

		return sqlService.getScoreSheetByCondition(conditionType, value);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String add(@RequestParam int id, @RequestParam String name, @RequestParam String info,
			@RequestParam double score) throws SQLException {

		sqlService.insert(id, name, info, score);
		return "success";

	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public boolean update(@RequestParam int id, @RequestParam String name, @RequestParam String info,
			@RequestParam double score) throws SQLException {

		return sqlService.update(id, name, info, score);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public boolean delete(@RequestParam int id) throws SQLException {

		return sqlService.delete(id);
	}
}
