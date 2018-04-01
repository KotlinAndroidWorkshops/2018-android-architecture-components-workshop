package fr.ekito.myweatherapp.domain

import fr.ekito.myweatherapp.data.datasource.webservice.json.geocode.Geocode
import fr.ekito.myweatherapp.data.datasource.webservice.json.geocode.Location

/**
 * Extract Location from Geocode
 */
fun Geocode.getLocation(): Location? = results.firstOrNull()?.geometry?.location