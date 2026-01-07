package com.hwasfy.pocsdk.network

class WeatherSdk {

    private val api = WeatherApi()

    suspend fun getWeatherText(): String {
        val weatherResponse = api.fetchCurrentWeather(
            latitude = 21.418700,
            longitude = 39.822633
        )

        val current = weatherResponse.currentWeather
        val units = weatherResponse.currentWeatherUnits

        return buildString {
            append("📍 Location: ${weatherResponse.latitude}, ${weatherResponse.longitude}\n")
            append("🕒 Time: ${current.time} (${weatherResponse.timezoneAbbreviation})\n")
            append("🌡 Temp: ${current.temperature} ${units.temperature}\n")
            append("💨 Wind: ${current.windSpeed} ${units.windSpeed}, Dir: ${current.windDirection}${units.windDirection}\n")
            append("🏔 Elevation: ${weatherResponse.elevation} m\n")
            append("🌞 Day/Night: ${if (current.isDay == 1) "Day" else "Night"}\n")
            append("☁ Weather: ${weatherCodeDescription(current.weatherCode)} (code: ${current.weatherCode})\n")
            append("⏱ Interval: ${current.interval} ${units.interval}\n")
            append("⚡ Generation Time: ${weatherResponse.generationTimeMs} ms")
        }
    }

    fun weatherCodeDescription(code: Int): String = when (code) {
        0 -> "Clear sky"
        1 -> "Mainly clear"
        2 -> "Partly cloudy"
        3 -> "Overcast"
        45, 48 -> "Fog"
        51, 53, 55 -> "Drizzle"
        61, 63, 65 -> "Rain"
        71, 73, 75 -> "Snow"
        80, 81, 82 -> "Rain showers"
        95 -> "Thunderstorm"
        else -> "Unknown"
    }
}
