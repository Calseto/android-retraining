package com.e.mandiriapps.data.network.remote

import com.e.mandiriapps.data.model.TransactionResponse
import com.e.mandiriapps.data.network.ServiceMandiri
import retrofit2.Response
import javax.inject.Inject

class TransactionRemoteDataSourceImpl @Inject constructor(private val service: ServiceMandiri) : TransactionRemoteDataSource{
    override suspend fun getTransaction(): Response<List<TransactionResponse>> {
        return service.getTransaction()
    }

}