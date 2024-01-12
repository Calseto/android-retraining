package com.e.mandiriapps.data.sharedpref.local

interface SharedPrefDataSource {
    fun saveToken(token: String)
    fun getToken(): String
}