package com.example.fitfusion.localdatabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitfusion.localdatabase.User
import com.example.fitfusion.localdatabase.UserDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class AppDatabaseViewModel(
    private val dao: UserDao
) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _user = MutableLiveData<List<User>>()
    val user: LiveData<List<User>> = _user

    fun getAllUsers(): Flow<List<User>> {
        return dao.getAllUsers()
    }

    fun getAllTrainings(): Flow<List<Training>> {
        return dao.getAllTrainings()
    }

    fun insert(user: User) {
        viewModelScope.launch {
            _isLoading.value = true
            dao.insert(user)
            _isLoading.value = false
        }
    }

    fun getUserByUsername(username: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _user.postValue(dao.getUserByUsername(username))
            _isLoading.value = false
        }
    }

    fun insert(training: Training) {
        viewModelScope.launch {
            _isLoading.value = true
            dao.insertTraining(training)
            _isLoading.value = false
        }
    }

    fun getTrainingById(id: Int): Flow<List<Training>> {
        return dao.getTrainingById(id)
    }
}