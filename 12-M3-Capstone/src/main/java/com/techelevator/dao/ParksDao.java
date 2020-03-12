package com.techelevator.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.model.Parks;
import com.techelevator.model.Weather;


public interface ParksDao {
	
	Parks getByCode(String parkCode);
	
	List<Parks> getAllParks();
	
	List<Weather> getWeatherByCode(String parkCode);
	
	
}
