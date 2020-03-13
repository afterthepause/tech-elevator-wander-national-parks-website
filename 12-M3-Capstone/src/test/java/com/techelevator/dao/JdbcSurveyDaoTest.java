package com.techelevator.dao;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.model.Parks;
import com.techelevator.model.Survey;

public class JdbcSurveyDaoTest extends DAOIntegrationTest {
	private SurveyDao surveyDao;
	private static SingleConnectionDataSource datasource;
	private JdbcTemplate jdbcTemplate;
	private static final String TEST_SURVEY_STATE = "Test State";
	private static final int TEST_SURVEY_COUNT = 1;
	
	
	@Before
	public void setup() {
		datasource = (SingleConnectionDataSource) super.getDataSource();
		surveyDao = new JdbcSurveyDao(datasource);
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Test
	public void save_new_survey() {
		Survey survey = mapRowToSurvey();
		String result = "TEST";
		
		Assert.assertNotEquals(result, survey.getParkCode());
		
		Survey actualSurvey = survey;
		Assert.assertNotNull(actualSurvey);
		assertReservationsAreEqual(survey, actualSurvey);
	}
	
	
	@Test
	public void get_all_surveys() {
		String sqlInsertPark = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) "
				+ "VALUES('ENP','test@gmail.com',?, 'active')";
		jdbcTemplate.update(sqlInsertPark, TEST_SURVEY_STATE);
		boolean hasSurvey = false;
		for (Survey survey : surveyDao.getAllSurveys()) {
			String example = survey.getState();
			if (example.equals("Test State")) {
				hasSurvey = true;
			}
		}
		Assert.assertTrue(hasSurvey);
		
	}
	@Test
	public void get_count_of_surveys() {
		String sqlInsertPark = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) "
				+ "VALUES('ENP','test@gmail.com','teststate', 'active')";
		jdbcTemplate.update(sqlInsertPark);
		boolean hasSurveyCount = false;
		
		for (Entry entry : surveyDao.getCountOfSurveysPerParkCode().entrySet()) {
			int example = (int)entry.getValue();
			if (example == TEST_SURVEY_COUNT) {
				hasSurveyCount = true;
			}
		}
		Assert.assertTrue(hasSurveyCount);
	}
	
	
	
	
	private void assertReservationsAreEqual(Survey expected, Survey actual) {
		assertEquals(expected.getParkCode(), actual.getParkCode());
		assertEquals(expected.getEmail(), actual.getEmail());
		assertEquals(expected.getState(), actual.getState());
		assertEquals(expected.getActivityLevel(), actual.getActivityLevel());
	}
	
	
	private Survey mapRowToSurvey() {
		
		Survey survey = new Survey();
		survey.setParkCode("GNP");
		survey.setEmail("test@gmail.com");
		survey.setState("Test");
		survey.setActivityLevel("active");
		surveyDao.save(survey);
		
		
		return survey;
		
	}
	
}
