package fr.ekito.myweatherapp.domain

import fr.ekito.myweatherapp.data.repository.json.weather.Forecastday
import fr.ekito.myweatherapp.data.repository.json.weather.Forecastday_
import fr.ekito.myweatherapp.data.repository.json.weather.Weather

/**
 * Extract Weather DailyForecastModel list from Weather
 */
fun Weather.getDailyForecasts(location: String): List<DailyForecastModel> {
    val txtList: List<Forecastday> = forecast?.txtForecast?.forecastday.orEmpty()
    return forecast?.simpleforecast?.forecastday.orEmpty()
        .map { f: Forecastday_ -> DailyForecastModel.from(location, f) }
        .map { f ->
            f.copy(
                fullText = txtList.firstOrNull { it.title ?: "" == f.day }?.fcttext ?: ""
            )
        }
        .filter { f -> !f.icon.startsWith(PREFIX) }

}