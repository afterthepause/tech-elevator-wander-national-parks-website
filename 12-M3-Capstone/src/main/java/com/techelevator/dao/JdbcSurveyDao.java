package com.techelevator.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		String sqlSelectAllSurveys = "select * from survey_result WHERE (surveycount FROM survey_result > 1)";
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
	
	@Override
	public Map<String, Integer> getCountOfSurveysPerParkCode() {
		Map<String, Integer> surveyCountMap = new LinkedHashMap<String, Integer>();
		String sqlCountSurveys = "select parkcode, count(parkcode) as surveycount from survey_result  group by parkcode order by surveycount desc";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCountSurveys);
		while(results.next()) {
			surveyCountMap.put(results.getString("parkcode"), results.getInt("surveycount"));
		}
		return surveyCountMap;
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
