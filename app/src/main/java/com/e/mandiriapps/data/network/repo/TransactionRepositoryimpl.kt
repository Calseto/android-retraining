package com.e.mandiriapps.data.network.repo

import com.e.mandiriapps.data.model.TransactionResponse
import com.e.mandiriapps.data.network.ServiceMandiri
import com.e.mandiriapps.data.network.remote.TransactionRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class TransactionRepositoryimpl @Inject constructor(private val transactionRemoteDataSource: TransactionRemoteDataSource) :
    TransactionRepository {
    override suspend fun getTransaction(): Response<List<TransactionResponse>> {
        return transactionRemoteDataSource.getTransaction()
    }
}