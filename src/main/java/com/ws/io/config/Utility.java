package com.ws.io.config;

import static com.ws.io.config.Constants.API_URL;
import static com.ws.io.config.Constants.APP_ID;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ws.io.model.WeatherData;

public class Utility {

	
	public static WeatherData getData(String cityName) {
        HttpHeaders headers = new HttpHeaders();
        
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // Send request with GET method, and Headers.
        ResponseEntity<String> response = restTemplate.exchange(API_URL+"q="+cityName+"&appid="+APP_ID, //
                HttpMethod.GET, entity, String.class);
 
        String result = response.getBody();
 
        JSONObject json = new JSONObject(result);
        System.out.println(json.toString());
        JSONObject mainObj = json.getJSONObject("main");
        Integer temp = (Integer) mainObj.getInt("temp");
        Integer humidity =  (Integer)mainObj.getInt("humidity");
        Integer pressure =  (Integer)mainObj.getInt("pressure");
        
        JSONArray weatherObj = json.getJSONArray("weather");
        JSONObject desObj = (JSONObject) weatherObj.get(0);
        String description = (String) desObj.getString("description");
        Integer id = (Integer) desObj.getInt("id");
        
        JSONObject windObj = json.getJSONObject("wind");
        Integer speed = (Integer) windObj.getInt("speed");
        Integer degre =  (Integer)windObj.getInt("deg");

        JSONObject sysObj = json.getJSONObject("sys");
        String country = (String) sysObj.getString("country");

        String city = json.getString("name");

        WeatherData data = new WeatherData();
        data.setDescription(description);
        data.setHumidity(humidity);
        data.setTemprature(temp);
        data.setPressure(pressure);
        data.setWindSpeed(speed);
        data.setWindDirection(degre);
        data.setCountry(country);
        data.setCity(city);
        data.setId(id);
        
        return data;
	}

  public static void main(String[] args) {
	 WeatherData w = getData("London");
	 System.out.println(w);
}
}
