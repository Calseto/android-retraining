package com.e.mandiriapps.data.sharedpref.local.impl

import android.content.SharedPreferences
import com.e.mandiriapps.data.sharedpref.local.SharedPrefDataSource
import javax.inject.Inject


class SharedPrefDataSourceImpl @Inject constructor (private val sharedPreferences: SharedPreferences) :
    SharedPrefDataSource {

    override fun saveToken(token: String) {
        sharedPreferences.edit().putString("TOKEN_KEY", token).apply()
    }

    override fun getToken(): String {
        return sharedPreferences.getString("TOKEN_KEY", "") ?: ""
    }
}