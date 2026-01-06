package com.hwasfy.pocsdk.models

import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeather(
    val temperature: Double,
    val windSpeed: Double
)