package com.ws.io.main;

import static com.ws.io.config.Constants.TOPIC;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ws.io.config.Utility;
import com.ws.io.model.WeatherData;
import com.ws.io.service.MessagingService;

@Controller
public class HomeController {

	@Autowired
	private MessagingService msgService;

	@GetMapping("/")
	String index() {
		return "index";
	}

	@RequestMapping("/publish")
	@PostMapping
	public ResponseEntity<?> publish(@RequestParam("city") String cityName) throws MqttException, InterruptedException {
		WeatherData data = Utility.getData(cityName);
		msgService.publish(TOPIC, data, 2, true);
		
		return new ResponseEntity<>("Successfully Publised.", HttpStatus.OK);

	}

	@RequestMapping("/publish_ui")
	@PostMapping
	public ResponseEntity<WeatherData> publishUi(@RequestParam("city") String cityName) throws MqttException, InterruptedException {
		WeatherData data = Utility.getData(cityName);
		msgService.publish(TOPIC, data, 2, true);
		
		WeatherData publishData = msgService.subscribe(TOPIC);
		return new ResponseEntity<>(publishData, HttpStatus.OK);

	}

	@RequestMapping("/subscribe")
	@GetMapping
	public ResponseEntity<WeatherData> subscribe() throws MqttException, InterruptedException {
		WeatherData msg = msgService.subscribe(TOPIC);
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

}
