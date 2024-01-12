package com.e.mandiriapps.data.sharedpref.repo

interface SharedPrefRepo {
    fun saveToken(token: String)
    fun getToken(): String
}