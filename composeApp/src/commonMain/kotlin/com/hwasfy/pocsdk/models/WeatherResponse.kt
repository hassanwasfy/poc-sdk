package com.hwasfy.pocsdk.models

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val currentWeather: CurrentWeather?
)