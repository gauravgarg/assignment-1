package com.ws.io.model;

import java.io.Serializable;

public class WeatherData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer temprature;
	private Integer humidity;
	private String description;
	private Integer pressure;
	private Integer windSpeed;
	private Integer windDirection;
	private String  city;
	private String  country;
	private Integer id;
	
	/**
	 * @return the temprature
	 */
	public Integer getTemprature() {
		return temprature;
	}
	/**
	 * @param temprature the temprature to set
	 */
	public void setTemprature(Integer temprature) {
		this.temprature = temprature;
	}
	/**
	 * @return the humidity
	 */
	public Integer getHumidity() {
		return humidity;
	}
	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the pressure
	 */
	public Integer getPressure() {
		return pressure;
	}
	/**
	 * @param pressure the pressure to set
	 */
	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}
	/**
	 * @return the windSpeed
	 */
	public Integer getWindSpeed() {
		return windSpeed;
	}
	/**
	 * @param windSpeed the windSpeed to set
	 */
	public void setWindSpeed(Integer windSpeed) {
		this.windSpeed = windSpeed;
	}
	/**
	 * @return the windDirection
	 */
	public Integer getWindDirection() {
		return windDirection;
	}
	/**
	 * @param windDirection the windDirection to set
	 */
	public void setWindDirection(Integer windDirection) {
		this.windDirection = windDirection;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "WeatherData [temprature=" + temprature + ", humidity=" + humidity + ", description=" + description
				+ ", pressure=" + pressure + ", windSpeed=" + windSpeed + ", windDirection=" + windDirection + ", city="
				+ city + ", country=" + country + ", id=" + id + "]";
	}
	
	
	
	
}



