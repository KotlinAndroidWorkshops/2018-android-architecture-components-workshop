package fr.ekito.myweatherapp.domain

import fr.ekito.myweatherapp.data.repository.json.geocode.Geocode
import fr.ekito.myweatherapp.data.repository.json.geocode.Location

/**
 * Extract Location from Geocode
 */
fun Geocode.getLocation(): Location? = results.firstOrNull()?.geometry?.location