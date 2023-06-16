package com.captsone.disastershield.network

import com.captsone.disastershield.model.Coordinate
import com.captsone.disastershield.model.ResponseWeather
import javax.inject.Inject

class MapRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getWeatherByCity(city: String): ResponseWeather{
        return apiService.getWeatherByCity(city, "24ab0f95b9eb4cfd2c214276e1162990", "metric")
    }
}