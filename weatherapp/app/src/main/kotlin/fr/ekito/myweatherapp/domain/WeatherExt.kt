package fr.ekito.myweatherapp.domain

import fr.ekito.myweatherapp.data.datasource.webservice.json.weather.ForecastDay
import fr.ekito.myweatherapp.data.datasource.webservice.json.weather.Forecastday_
import fr.ekito.myweatherapp.data.datasource.webservice.json.weather.Weather

/**
 * Extract Weather DailyForecastModel list from Weather
 */
fun Weather.getDailyForecasts(location: String): List<DailyForecastModel> {
    val txtList: List<ForecastDay> = forecast?.txtForecast?.forecastday.orEmpty()
    return forecast?.simpleForecast?.forecastday.orEmpty()
        .map { f: Forecastday_ -> DailyForecastModel.from(location, f) }
        .map { f ->
            f.copy(
                fullText = txtList.firstOrNull { it.title ?: "" == f.day }?.fcttext ?: ""
            )
        }
        .filter { f -> !f.icon.startsWith(PREFIX) }

}