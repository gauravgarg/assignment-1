# Live Weather :

This is the small POC for fetching latest city's weather data with the help of open weather API and MQTT.

Steps : 

1. we called open weather API to fetch the latest weather data of the city.
2. weather API response JSON data will be transform in java model class and serialize to bytestream.
3. Converted serialize data to MQTT message and send it to topic "ws/topic/event" on open mosquito broker.
4. subscriber connected to broker and fetch incoming message on topic "ws/topic/event".
5. UI application is showing this data in visual form .
        
Improvement : 

Broker Improvement: 
TCP bd AMQP :
Application Improvement ; 
Error/Exception handling
Distributed logging expose with push to elastic search
Containerise the application and deployed to Kubernetes cluster.
CI/CD pipeline.


1. I have used paho eclipse client library for mqtt implementation .
2. we have used open broker for topic management 

Publish : POST
URL : http://localhost:8080/publish?city=oslo
Response :
{
 Successfully Publised.
}

Publish : GET
URL : http://localhost:8080/subscribe        
Response :
{
    "temprature": 281,
    "humidity": 87,
    "description": "moderate rain",
    "pressure": 975,
    "windSpeed": 2,
    "windDirection": 247,
    "city": "Oslo",
    "country": "NO",
    "id": 501
}
