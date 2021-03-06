package com.techelevator.dao;

import java.util.List;
import java.util.Map;

import com.techelevator.model.Survey;

public interface SurveyDao {
	
	public void save(Survey survey);
	
	public List<Survey> getAllSurveys();
	
	public Map<String, Integer> getCountOfSurveysPerParkCode();
	
	
}
