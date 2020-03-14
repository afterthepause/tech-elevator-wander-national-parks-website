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
	
	
	public String getTempMessage() {
		return tempMessage;
	}
	
	public LocalDate getForecastDate(Long days) {
		return LocalDate.now().plusDays(days);
	}
	
	public void setTempMessage(Integer high, Integer low) {
		if (high >= 75 || low >= 75) {
			this.tempMessage += "Pack an extra gallon of water... dude.";
		}
		if(high <= 20 || low <= 20) {
			this.tempMessage += "Be careful, it's real cold out... dude. Don't stay out too long.";
		}
		if((high - low) >= 20) {
			this.tempMessage += "Wear breathable layers... dude.";
		}
		
	}
	
	public String getForecastMessage() {
		return forecastMessage;
	}
	
	public void setForecastMessage(String forecast) {
		if (forecast.equals("snow")) {
			this.forecastMessage = "Pack snowshoes... dude.";
		}
		if (forecast.equals("rain")) {
			this.forecastMessage = "Pack rain gear and waterproof shoes... dude.";
		}
		if (forecast.equals("thunderstorms")) {
			this.forecastMessage = "Don't go hiking... dude.";
		}
		if (forecast.equals("sunny")) {
			this.forecastMessage = "Pack sunblock... dude.";
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
