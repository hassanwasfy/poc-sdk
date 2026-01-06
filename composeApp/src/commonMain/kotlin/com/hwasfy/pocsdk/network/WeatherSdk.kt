package com.hwasfy.pocsdk.network

class WeatherSdk {

    private val api = WeatherApi()

    suspend fun getWeatherText(): String {
        val weather = api.fetchCurrentWeather(
            latitude = 30.0444,   // Cairo
            longitude = 31.2357
        )

        return "Temp: ${weather.temperature}°C, Wind: ${weather.windSpeed} km/h"
    }
}
