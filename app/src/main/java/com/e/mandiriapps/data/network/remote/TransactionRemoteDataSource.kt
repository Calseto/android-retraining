package com.e.mandiriapps.data.network.remote

import com.e.mandiriapps.data.model.TransactionResponse
import retrofit2.Response

interface TransactionRemoteDataSource {
    suspend fun getTransaction(): Response<List<TransactionResponse>>
}