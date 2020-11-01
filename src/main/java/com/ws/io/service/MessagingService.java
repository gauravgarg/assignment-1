package com.ws.io.service;

import org.apache.commons.lang3.SerializationUtils;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.io.model.WeatherData;

@Service
public class MessagingService {

	@Autowired
	private IMqttClient mqttClient;
	
	private WeatherData data;

	
	public void publish(final String topic, final WeatherData payload, int qos, boolean retained)
			throws MqttPersistenceException, MqttException {
		MqttMessage mqttMessage = new MqttMessage();
		mqttMessage.setPayload(SerializationUtils.serialize(payload));
		mqttMessage.setQos(qos);
		mqttMessage.setRetained(retained);
		mqttClient.publish(topic, mqttMessage);
		System.out.println("Message published succesfully.. "+payload);		
		System.out.println(payload);		
	}

	public WeatherData subscribe(final String topic) throws MqttException, InterruptedException {
		System.out.println("Messages received:");
		mqttClient.subscribeWithResponse(topic, (tpic, msg) -> {
			data = SerializationUtils.deserialize(msg.getPayload());
			System.out.println("Message retrieve from broker");
			System.out.println(msg.getId() + " -> " + data);
			this.setData(data);
		});
		return this.getData();

	}

	/**
	 * @return the data
	 */
	public WeatherData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(WeatherData data) {
		this.data = data;
	}


	
	

}
