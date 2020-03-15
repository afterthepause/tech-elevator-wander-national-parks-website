package com.techelevator.model;

import java.time.LocalDate;

public class Weather {

	
	public String parkCode;
	public int fiveDayForecastValue;
	public Integer low;
	public Integer high;
	public LocalDate forecastDate;
	public String forecast;
	public String tempMessage = "";
	public String forecastMessage = "";
	
	
	public String getForecastMessage() {
		return forecastMessage;
	}
	
	public void setForecastMessage(String forecast) {
		if (forecast.equals("snow")) {
			this.forecastMessage = "Pack snowshoes";
		}
		if (forecast.equals("rain")) {
			this.forecastMessage = "Pack rain gear and waterproof shoes";
		}
		if (forecast.equals("thunderstorms")) {
			this.forecastMessage = "Don't go hiking";
		}
		if (forecast.equals("sunny")) {
			this.forecastMessage = "Pack sunblock";
		}
	}
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	
	public Integer getLow() {
		return low;
	}
	
	public void setLow(Integer low) {
		this.low = low;
	}
	
	public Integer getHigh() {
		return high;
	}
	
	public void setHigh(Integer high) {
		this.high = high;
	}
	

	
	public String getForecast() {
		return forecast;
	}
	
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	
	
}
