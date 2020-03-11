package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Parks;
import com.techelevator.model.Weather;


public interface ParksDao {
	
	Parks getByCode(String parkCode);
	
	Weather getWeatherByCode(String parkCode);
	
	
}
