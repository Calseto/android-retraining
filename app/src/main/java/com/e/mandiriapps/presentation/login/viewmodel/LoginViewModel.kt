package com.e.mandiriapps.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.mandiriapps.helper.SharedPref
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor():ViewModel(){
    @Inject
    lateinit var sharedPref:SharedPref

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> get() = _loginResult

    enum class LoginResult {
        EMPTY_PASSWORD,
        INCORRECT_PASSWORD,
        CORRECT_PASSWORD
    }

    fun checkPassword(password: String) {
        when {
            password.isEmpty() -> _loginResult.value = LoginResult.EMPTY_PASSWORD
            password!="pass"   -> _loginResult.value = LoginResult.INCORRECT_PASSWORD
            password=="pass"   -> _loginResult.value = LoginResult.CORRECT_PASSWORD
        }
    }
}