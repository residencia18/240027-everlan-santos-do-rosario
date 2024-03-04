async function getWeather() {
    const weatherData = await fetch("https://api.openweathermap.org/data/2.5/weather?q=Ilhéus,br&appid=2632638ccd455174294b5b12c50bad5b").then((response) => response.json());
  
    const temperatureElement = document.getElementById("temperature");
    temperatureElement.textContent = formatarTemperatura((weatherData.main.temp - 273.15)) + "°C";
  
    const humidityElement = document.getElementById("humidity");
    humidityElement.textContent = weatherData.main.humidity + "%";
  
    const windSpeedElement = document.getElementById("windSpeed");
    windSpeedElement.textContent = weatherData.wind.speed + "km/h";
  
    const weatherDescriptionElement = document.getElementById("weatherDescription");
    weatherDescriptionElement.textContent = weatherData.weather[0].description;
  }
  
  function formatarTemperatura(temperatura) {
    return parseFloat(temperatura).toFixed(2);
  }

  getWeather();
  