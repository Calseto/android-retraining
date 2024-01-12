package com.e.mandiriapps.data.sharedpref.usecase

import com.e.mandiriapps.data.sharedpref.repo.SharedPrefRepo
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(private val sharedPrefRepo: SharedPrefRepo)  {
     fun getToken(): String {
        return sharedPrefRepo.getToken()
    }
}