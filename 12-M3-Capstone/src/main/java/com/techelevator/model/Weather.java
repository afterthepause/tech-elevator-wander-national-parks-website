package com.techelevator.model;

public class Weather {

	
	public String parkCode;
	public int fiveDayForecastValue;
	public int lowFar;
	public int highFar;
	public int lowCel;
	public int highCel;
	public String forecast;
	public String tempMessage = "";
	public String forecastMessage = "";
	
	
	public String getTempMessage() {
		return tempMessage;
	}
	
	public void setTempMessage(int high, int low) {
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
	
	public int getLowFar() {
		return lowFar;
	}
	
	public void setLowFar(int low) {
		this.lowFar = low;
	}
	
	public int getHighFar() {
		return highFar;
	}
	
	public void setHighFar(int high) {
		this.highFar = high;
	}
	
	public int getLowCel() {
		return lowCel;
	}
	
	public void setLowCel(int lowCel) {
		this.lowCel = (int) ((getLowFar()-32) / 1.8 );
	}
	
	public int getHighCel() {
		return highCel;
	}
	public void setHighCel(int highCel) {
		this.highCel = (int) ((getHighFar()-32) / 1.8 );
	}
	
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	
	
}
