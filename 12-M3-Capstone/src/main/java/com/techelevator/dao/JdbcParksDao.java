package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


import com.techelevator.model.Parks;
import com.techelevator.model.Weather;

public class JdbcParksDao implements ParksDao {
	
	//sql statements
	private static final String SELECT_PARKS_SQL = "SELECT park.parkcode, park.parkname, park.state, park.acreage, park.elevationinfeet, park.milesoftrail, park.numberofcampsites, park.climate, park.yearfounded, park.annualvisitorcount, park.inspirationalquote, park.inspirationalquotesource, park.parkdescription, park.entryfee, park.numberofanimalspecies FROM park";
	private static final String SELECT_WEATHER_SQL = "SELECT weather.parkcode, weather.fivedayforecastvalue, weather.low, weather.high, weather.forecast FROM weather";
	
	private final JdbcTemplate jdbcTemplate;
	
	
	//connect to database
	@Autowired
	public JdbcParksDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//pull in park by Park Code
	@Override
	public Parks getByCode(String parkCode) {
		SqlRowSet result = jdbcTemplate.queryForRowSet(SELECT_PARKS_SQL + " Where code = ?", parkCode);
		if(result.next()) {
			return mapRowSetToPark(result);
		}
		return null;
	}
	
	//pull in weather by Park Code
	@Override
	public Weather getWeatherByCode(String parkCode) {
		SqlRowSet result = jdbcTemplate.queryForRowSet(SELECT_WEATHER_SQL + " Where code = ?", parkCode);
		if(result.next()) {
			return mapRowSetToWeather(result);
		}
		return null;
	}
	
	
	//add parks to map
	private List<Parks> mapRowSetToParks(SqlRowSet pResults) {
	        List<Parks> parks = new ArrayList<>();
	        while (pResults.next()) {
	            parks.add(mapRowSetToPark(pResults));
	        }
	        return parks;
	    }
	
	private Parks mapRowSetToPark(SqlRowSet pResults) {
        Parks parks = new Parks();
        parks.setParkCode(pResults.getString("parkcode"));
        parks.setParkName(pResults.getString("parkname"));
        parks.setState(pResults.getString("state"));
        parks.setAcreage(pResults.getInt("acreage"));
        parks.setElevationInFeet(pResults.getInt("elevationinfeet"));
        parks.setMilesOfTrail(pResults.getDouble("milesoftrail"));
        parks.setNumberOfCampsites(pResults.getInt("numberofcampsites"));
        parks.setClimate(pResults.getString("climate"));
        parks.setYearFounded(pResults.getInt("yearfounded"));
        parks.setAnnualVisitorCount(pResults.getInt("annualvisitorcount"));
        parks.setInspirationalQuote(pResults.getString("insprationalquote"));
        parks.setInspirationalQuoteSource(pResults.getString("inspirationalquotesource"));
        parks.setParkDescription(pResults.getString("parkdescription"));
        parks.setEntryFee(pResults.getInt("entryfee"));
        parks.setNumberOfAnimalSpecies(pResults.getInt("numberofanimalspecies"));
        return parks;
    }
	
	
	private List<Weather> mapRowSetToWeathers(SqlRowSet wResults) {
        List<Weather> weather = new ArrayList<>();
        while (wResults.next()) {
            weather.add(mapRowSetToWeather(wResults));
        }
        return weather;
    }
	
	
	private Weather mapRowSetToWeather(SqlRowSet wResults) {
		Weather weather = new Weather();
		weather.setParkCode(wResults.getString("parkcode"));
		weather.setFiveDayForecastValue(wResults.getInt("fivedayforecastvalue"));
		weather.setLow(wResults.getInt("low"));
		weather.setHigh(wResults.getInt("high"));
		weather.setForecast(wResults.getString("forecast"));
		return weather;
	}

	
	

	
}
