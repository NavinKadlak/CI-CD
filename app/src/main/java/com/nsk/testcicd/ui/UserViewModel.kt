package com.nsk.testcicd.ui

import androidx.lifecycle.ViewModel
import com.nsk.testcicd.domain.usecase.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _userName = MutableStateFlow("")

    val userName = _userName.asStateFlow()

    fun loadUser() {

        viewModelScope.launch {

            _userName.value = getUserUseCase()
        }
    }
}