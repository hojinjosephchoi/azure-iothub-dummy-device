package com.lattekafe.dummysensor.model;

import com.google.gson.Gson;

public class WeatherModel {
	
	private String deviceId;
	private int temperature;
	private int humidity;
	private int dust;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public int getDust() {
		return dust;
	}
	public void setDust(int dust) {
		this.dust = dust;
	}
	
	public String serialize(){
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}
