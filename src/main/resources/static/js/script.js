var unit = "C";

function getLocation() {
    $.get("https://ipapi.co/json", function(data) {
        getWeather(data.city);
    });
}

function getWeather(city) {
	if(city == ''){
		alert("please type city again.");
		return;
	}
    var api = "http://localhost:8080/publish_ui?city=";
    var $http = api + city
    $.getJSON($http, function(data) {
        console.log(data);
        temp = Math.round((data.temprature)-273.15);
        status = data.description;
        iconId = data.id;
        pressure = data.pressure;
        humidity = data.humidity;
        windSpeed = data.windspeed ? (data.windspeed * 3.6).toFixed(0) : "N/A ";
        windDirection = data.windDirection ;
        city = data.city;
        country = data.country;

        var hours = new Date().getHours();
        var dayOrNight = hours > 6 && hours < 22 ? "day" : "night";

        inputTextValue = city + ", " + country;
        $("#location").val(inputTextValue);
        $(".forecast-status")
            .find(".wi")
            .addClass("wi-owm-" + dayOrNight + "-" + iconId);
        $("#temperature").text(temp);
        $("#status").text(status[0].toUpperCase() + status.slice(1));
        $(".pressure").text(pressure + " hPa");
        $(".humidity").text(humidity + " %");
        $(".windSpeed").text(windSpeed);
        $(".windDirection").text(
            windDirection + "deg " + degToCompass(windDirection)
        );
        $(".wi-wind").addClass("towards-" + windDirection + "-deg");
        //changeBackground(iconId);
    });
}

function degToCompass(num) {
    var val = Math.floor(num / 22.5 + 0.5);
    var arr = [
        "(N)",
        "(NNE)",
        "(NE)",
        "(ENE)",
        "(E)",
        "(ESE)",
        "(SE)",
        "(SSE)",
        "(S)",
        "(SSW)",
        "(SW)",
        "(WSW)",
        "(W)",
        "(WNW)",
        "(NW)",
        "(NNW)"
    ];
    return arr[val % 16] || "";
}


function getDate() {
    var d = new Date();
    var date = d.toLocaleDateString();
    $("#date").html(date);
}

function getClock() {
    var d = new Date(),
        h = d.getHours(),
        m = d.getMinutes(),
        s = d.getSeconds();
    h = checkTime(h);
    m = checkTime(m);
    s = checkTime(s);
    $("#time").text(h + ":" + m + ":" + s);
    var t = setTimeout(getClock, 500);
}

function checkTime(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}

getDate();
getClock();
getLocation();

window.onkeyup = keyup;
var inputTextValue;

function keyup(e) {
    //setting your input text to the global Javascript Variable for every key press
    inputTextValue = e.target.value;
    if (e.keyCode == 13) {
        console.log(inputTextValue);
        if (~inputTextValue.indexOf(",")) inputTextValue = "";
        getWeather(inputTextValue);
    }
}

$(document).ready(function() {
    $("#location").on("click", function() {
        $(this).val("");
        inputTextValue = "";
    });

    $('form').submit(function() {
        if (~inputTextValue.indexOf(",")) inputTextValue = "";
        getWeather(inputTextValue);
        return false;
    });

});