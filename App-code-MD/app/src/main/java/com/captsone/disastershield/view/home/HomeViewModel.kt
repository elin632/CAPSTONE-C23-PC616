package com.captsone.disastershield.view.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.captsone.disastershield.model.Coordinate
import com.captsone.disastershield.network.MapRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MapRepository
) : ViewModel() {
    private val _dataMap = MutableLiveData<Coordinate>()
    val dataMap: LiveData<Coordinate> = _dataMap

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    private val _cityName = MutableLiveData<String>()
    val cityName: LiveData<String> = _cityName

    fun getMapData(city: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _dataMap.value = repository.getWeatherByCity(city).coordinate
                _cityName.value = city
            } catch (e: Exception) {
                _message.value = e.message.toString()
            }
            finally {
                _isLoading.value = false
            }
        }
    }
}
