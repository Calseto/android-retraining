package com.e.mandiriapps.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.mandiriapps.data.sharedpref.usecase.GetTokenUseCase
import com.e.mandiriapps.data.sharedpref.usecase.SaveToken
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase, private val saveToken: SaveToken
):ViewModel(){

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> get() = _loginResult

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    private val _tokenAvaibity = MutableLiveData(false)
    val tokenAvaibility: LiveData<Boolean> get() = _tokenAvaibity


    enum class LoginResult {
        EMPTY_PASSWORD,
        INCORRECT_PASSWORD,
        CORRECT_PASSWORD
    }

    fun saveNewToken(){
        val dummyToken:String = UUID.randomUUID().toString()
        saveToken.saveToken(dummyToken)
    }

    fun checkTokenAvailability(){
        val token = getTokenUseCase.getToken()
        if (!token.isEmpty()){
            _tokenAvaibity.postValue(true)
        }
    }
    fun checkPassword(password: String) {
        when {
            password.isEmpty() -> {
                _loginResult.value = LoginResult.EMPTY_PASSWORD
                _toastMessage.postValue("Harap isi password")
            }
            password!="pass"   -> {
                _loginResult.value = LoginResult.INCORRECT_PASSWORD
                _toastMessage.postValue("Password Salah")
            }
            password=="pass"   -> {
                _loginResult.value = LoginResult.CORRECT_PASSWORD
                _toastMessage.postValue("Password Benar")
            }
        }
    }
}