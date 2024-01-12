package com.e.mandiriapps.data.sharedpref.repo.impl

import com.e.mandiriapps.data.sharedpref.local.SharedPrefDataSource
import com.e.mandiriapps.data.sharedpref.repo.SharedPrefRepo
import javax.inject.Inject

class SharedPrefRepoImpl @Inject constructor (private val sharedPrefDataSource: SharedPrefDataSource) : SharedPrefRepo {

    override fun saveToken(token: String) {
        sharedPrefDataSource.saveToken(token)
    }

    override fun getToken(): String {
        return sharedPrefDataSource.getToken()
    }
}