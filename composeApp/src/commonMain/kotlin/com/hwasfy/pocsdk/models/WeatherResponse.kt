package com.hwasfy.pocsdk.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class WeatherResponse(
    @SerialName("latitude") val latitude: Double,
    @SerialName("longitude") val longitude: Double,
    @SerialName("generationtime_ms") val generationTimeMs: Double,
    @SerialName("utc_offset_seconds") val utcOffsetSeconds: Int,
    @SerialName("timezone") val timezone: String,
    @SerialName("timezone_abbreviation") val timezoneAbbreviation: String,
    @SerialName("elevation") val elevation: Double,
    @SerialName("current_weather_units") val currentWeatherUnits: CurrentWeatherUnits,
    @SerialName("current_weather") val currentWeather: CurrentWeather
)