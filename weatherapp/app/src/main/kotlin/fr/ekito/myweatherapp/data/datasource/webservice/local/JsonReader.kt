package fr.ekito.myweatherapp.data.datasource.local

import fr.ekito.myweatherapp.data.repository.json.geocode.Geocode
import fr.ekito.myweatherapp.data.repository.json.geocode.Location
import fr.ekito.myweatherapp.data.repository.json.weather.Weather

/**
 * Json reader
 */
interface JsonReader {
    fun getAllLocations(): Map<Location, String>
    fun getWeather(name: String): Weather
    fun getGeocode(name: String): Geocode
}