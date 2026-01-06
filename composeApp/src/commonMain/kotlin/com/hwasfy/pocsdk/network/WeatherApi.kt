package com.hwasfy.pocsdk.network

import com.hwasfy.pocsdk.models.CurrentWeather
import com.hwasfy.pocsdk.models.WeatherResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class WeatherApi {

    suspend fun fetchCurrentWeather(
        latitude: Double,
        longitude: Double
    ): CurrentWeather {

        val response: WeatherResponse =
            HttpClientProvider.client.get(
                "https://api.open-meteo.com/v1/forecast"
            ) {
                parameter("latitude", latitude)
                parameter("longitude", longitude)
                parameter("current_weather", true)
            }.body()

        return response.currentWeather
            ?: error("Weather data not available")
    }
}
