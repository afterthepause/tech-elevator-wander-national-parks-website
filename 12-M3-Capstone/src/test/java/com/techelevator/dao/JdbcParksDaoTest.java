package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.model.Parks;
import com.techelevator.model.Weather;

public class JdbcParksDaoTest extends DAOIntegrationTest{
	
	private ParksDao parksDao;
	private static SingleConnectionDataSource datasource;
	private JdbcTemplate jdbcTemplate;
	private static final String TEST_PARK = "Test Park";
	
	@Before
	public void setup() {
		datasource = (SingleConnectionDataSource) super.getDataSource();
		parksDao = new JdbcParksDao(datasource);
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Test
	public void get_park_by_parkcode() {
		
		Parks park = new Parks();
		park.setParkCode("test");
		park.setParkName("testname");
		park.setState("teststate");
		park.setAcreage(100);
		park.setElevationInFeet(500);
		park.setMilesOfTrail(20);
		park.setNumberOfCampsites(20);
		park.setClimate("testclimate");
		park.setYearFounded(2000);
		park.setAnnualVisitorCount(300);
		park.setInspirationalQuote("testquote");
		park.setInspirationalQuoteSource("testsource");
		park.setParkDescription("testdescription");
		park.setEntryFee(5);
		park.setNumberOfAnimalSpecies(6);
		savePark(park);
		
		List<Parks> parks = new ArrayList<Parks>();
		parks.add(parksDao.getByCode(park.getParkCode()));
		
		Assert.assertNotNull(parks);
		Assert.assertEquals(1, parks.size());
	}
	
	@Test
	public void get_weather_by_parkcode() {
		Parks park = new Parks();
		park.setParkCode("test");
		park.setParkName("testname");
		park.setState("teststate");
		park.setAcreage(100);
		park.setElevationInFeet(500);
		park.setMilesOfTrail(20);
		park.setNumberOfCampsites(20);
		park.setClimate("testclimate");
		park.setYearFounded(2000);
		park.setAnnualVisitorCount(300);
		park.setInspirationalQuote("testquote");
		park.setInspirationalQuoteSource("testsource");
		park.setParkDescription("testdescription");
		park.setEntryFee(5);
		park.setNumberOfAnimalSpecies(6);
		savePark(park);
		
		Weather weather = new Weather();
		weather.setParkCode("test");
		weather.setFiveDayForecastValue(1);
		weather.setLow(10);
		weather.setHigh(40);
		weather.setForecast("snow");
		saveWeather(weather);
		
		List<Weather> weatherList = parksDao.getWeatherByCode(weather.getParkCode());
		Assert.assertNotNull(weatherList);
		Assert.assertEquals(1, weatherList.size());
	}
	
	@Test
	public void get_all_parks() {
		String sqlInsertPark = "INSERT INTO park(parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) "
				+ "VALUES('testcode', ?, 'teststate', 100, 100, 100, 10, 'testclimate', 2000, 200, 'testquote', 'testsource', 'testdescript', 10, 10)";
		jdbcTemplate.update(sqlInsertPark, TEST_PARK);
		boolean hasParks = false;
		for (Parks park : parksDao.getAllParks()) {
			String example = park.getParkName();
			if (example.equals("Test Park")) {
				hasParks = true;
			}
		}

		Assert.assertTrue(hasParks);
	}
	
	
	private Parks savePark(Parks newPark) {
		
		String sqlSavePark = "INSERT INTO park(parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sqlSavePark, newPark.getParkCode(), newPark.getParkName(), newPark.getState(), newPark.getAcreage(), newPark.getElevationInFeet(), newPark.getMilesOfTrail(),
				newPark.getNumberOfCampsites(), newPark.getClimate(), newPark.getYearFounded(), newPark.getAnnualVisitorCount(), newPark.getInspirationalQuote(), 
				newPark.getInspirationalQuoteSource(), newPark.getParkDescription(), newPark.getEntryFee(), newPark.getNumberOfAnimalSpecies() );
		
		return newPark;
	}
	private Weather saveWeather(Weather newWeather) {
		
		String sqlSaveWeather = "INSERT INTO weather(parkcode, fivedayforecastvalue, low, high, forecast) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sqlSaveWeather, newWeather.getParkCode(), newWeather.getFiveDayForecastValue(), newWeather.getLow(), 
				newWeather.getHigh(), newWeather.getForecast());
		
		return newWeather;
	}
	
}
