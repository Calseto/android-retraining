package com.e.mandiriapps.data.network

import com.e.mandiriapps.data.model.TransactionResponse
import retrofit2.Response
import retrofit2.http.GET

interface ServiceMandiri {

    @GET("/transaction  ")
    suspend fun getTransaction():Response<List<TransactionResponse>>
}