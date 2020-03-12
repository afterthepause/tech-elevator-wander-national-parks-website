package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Survey;

@Component
public class JdbcSurveyDao implements SurveyDao{

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Survey survey) {
		Long id = getNextId();
		String sqlInsertSurvey = "insert into survey_result(surveyid, parkcode, emailaddress, state, activitylevel) values(?,?,?,?,?)";
		jdbcTemplate.update( sqlInsertSurvey, id, survey.getParkCode(), survey.getEmail(), survey.getState(), survey.getActivityLevel() );
		survey.setSurveyId(id);
	}
	
	@Override
	public List<Survey> getAllSurveys() {
		List<Survey> allSurveys = new ArrayList<>();
		String sqlSelectAllSurveys = "select * from survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while(results.next()) {
			Survey survey = new Survey();
			survey.setSurveyId(results.getLong("surveyid"));
			survey.setParkCode(results.getString("parkcode"));
			survey.setEmail(results.getString("emailaddress"));
			survey.setState(results.getString("state"));
			survey.setActivityLevel(results.getString("activitylevel"));
			allSurveys.add(survey);
		}
		
		return allSurveys;
	}
	
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyid')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long id = null;
		if (results.next()) {
			id = results.getLong(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next survey id from sequence");
		}
		return id;
	}


	
	
	
}