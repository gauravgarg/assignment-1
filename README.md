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

Authentication/Authorisation : 
1. TLS/SSL certificates implementation 
2. Trust store/key store 

Scalability:
1. broker scalability :
2. hosted/deploy in the cloud , scale multiple instance based on TPS.
3. API gateway for publish/subscribe api for web client.
4. Lambda function for processing these API's

1. I have used paho eclipse client library for mqtt implementation .
2. we have used open broker for topic management 

Publish : POST
URL : http://localhost:8080/publish?city=oslo
Response :
{
 Successfully Publised.
}
<img width="1100" alt="Screenshot 2020-11-01 at 11 36 01 PM" src="https://user-images.githubusercontent.com/1383978/97810893-1bfde780-1c9d-11eb-8a92-b721e12cd7ec.png">

Subsciber : GET
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
<img width="1095" alt="Screenshot 2020-11-01 at 11 52 44 PM" src="https://user-images.githubusercontent.com/1383978/97810936-62534680-1c9d-11eb-830d-7344d3651620.png">

<img width="610" alt="Screenshot 2020-11-01 at 11 46 34 PM" src="https://user-images.githubusercontent.com/1383978/97810807-83676780-1c9c-11eb-9240-0c368adfa719.png">

Temperature and other data will be updated based on city search from search bar.
