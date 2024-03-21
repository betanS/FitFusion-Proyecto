package com.example.fitfusion.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitfusion.data.network.MainRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val productsRepository = MainRepository()

    private val _currentWeather = MutableLiveData<WeatherResponse>()
    val currentWeather: LiveData<WeatherResponse> = _currentWeather

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getCurrentWeather(city: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _currentWeather.postValue(productsRepository.getCurrentWeather(city))
            _isLoading.value = false
        }
    }
}