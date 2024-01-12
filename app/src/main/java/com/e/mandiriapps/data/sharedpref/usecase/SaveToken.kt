package com.e.mandiriapps.data.sharedpref.usecase

import com.e.mandiriapps.data.sharedpref.repo.SharedPrefRepo
import javax.inject.Inject

class SaveToken @Inject constructor(private val sharedPrefRepo: SharedPrefRepo)  {
    fun saveToken(token: String) {
        sharedPrefRepo.saveToken(token)
    }
}