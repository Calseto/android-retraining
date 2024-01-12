package com.e.mandiriapps.data.network.repo

import com.e.mandiriapps.data.model.TransactionResponse
import com.e.mandiriapps.data.network.remote.TransactionRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

interface TransactionRepository{
    suspend fun getTransaction(): Response<List<TransactionResponse>>
}