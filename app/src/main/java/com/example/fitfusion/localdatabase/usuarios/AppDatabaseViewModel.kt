package com.example.fitfusion.localdatabase.usuarios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AppDatabaseViewModel(
    private val dao: UserDao
) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun getAllUsers(): Flow<List<User>> {
        return dao.getAllUsers()
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
            _user.postValue(dao.getUserByUsername(username).first())
            _isLoading.value = false
        }
    }
}