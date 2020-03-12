package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Parks;
import com.techelevator.model.Weather;

@Component
public class JdbcParksDao implements ParksDao {
	
	//sql statements
	private static final String SELECT_PARKS_SQL = "SELECT * FROM park";
	private static final String SELECT_WEATHER_SQL = "SELECT * FROM weather";
	
	private final JdbcTemplate jdbcTemplate;
	
	
	//connect to database
	@Autowired
	public JdbcParksDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//pull in park by Park Code
	@Override
	public Parks getByCode(String parkCode) {
		SqlRowSet result = jdbcTemplate.queryForRowSet(SELECT_PARKS_SQL + " Where parkcode = ?", parkCode);
		if(result.next()) {
			return mapRowSetToPark(result);
		}
		return null;
	}
	
	
	//pull in weather by Park Code
	@Override
	public List<Weather> getWeatherByCode(String parkCode) {
		List<Weather> weatherList = new ArrayList<Weather>();
		String sql = (SELECT_WEATHER_SQL +  " Where parkcode = ?");
				SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkCode);
		while(results.next()) {
			Weather weather = mapRowSetToWeather(results);
			weatherList.add(weather);
			
		}
		return weatherList;
	}
	
	@Override
	public List<Parks> getAllParks() {
		List<Parks> parks = new ArrayList<Parks>();
		String sql = SELECT_PARKS_SQL;
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while(results.next()) {
			Parks park = mapRowSetToPark(results);
			parks.add(park);
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
        parks.setInspirationalQuote(pResults.getString("inspirationalquote"));
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
