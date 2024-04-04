package com.example.fitfusion.localdatabase

import TrainingDao
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitfusion.localdatabase.NotMyApp.Companion.database
import com.example.fitfusion.localdatabase.usuarios.User
import com.example.fitfusion.localdatabase.usuarios.UserDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TrainingDatabaseViewModel(
    private val dao: TrainingDao
) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun getAllTrainings(): Flow<List<Training>> {
        return dao.getAllTrainings()
    }

    fun insert(training: Training) {
        viewModelScope.launch {
            _isLoading.value = true
            dao.insert(training)
            _isLoading.value = false
        }
    }
}