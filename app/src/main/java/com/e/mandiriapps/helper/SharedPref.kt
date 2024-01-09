package com.e.mandiriapps.helper

import android.content.Context
import android.content.SharedPreferences

class SharedPref(val sharedPreferences: SharedPreferences) {


    fun saveToken(token:String){
        sharedPreferences.edit().putString(TOKEN_KEY,token).apply()
    }

    fun getToken():String{
        return sharedPreferences.getString(TOKEN_KEY,"") ?: ""
    }

    fun clearToken(){
        val editor =sharedPreferences.edit()
        editor.apply{
            clear()
            apply()
        }
    }
    companion object{
        private const val TOKEN_KEY="token_key"
    }
}