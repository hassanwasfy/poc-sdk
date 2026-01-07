package com.hwasfy.pocsdk.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherUnits(
    @SerialName("time") val time: String,
    @SerialName("interval") val interval: String,
    @SerialName("temperature") val temperature: String,
    @SerialName("windspeed") val windSpeed: String,
    @SerialName("winddirection") val windDirection: String,
    @SerialName("is_day") val isDay: String,
    @SerialName("weathercode") val weatherCode: String
)