package com.e.mandiriapps.data.network.module

import com.e.mandiriapps.data.network.ServiceMandiri
import com.e.mandiriapps.data.network.remote.TransactionRemoteDataSource
import com.e.mandiriapps.data.network.remote.TransactionRemoteDataSourceImpl
import com.e.mandiriapps.data.network.repo.TransactionRepository
import com.e.mandiriapps.data.network.repo.TransactionRepositoryimpl
import com.e.mandiriapps.data.network.usecase.GetAllTransactionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MessageModule {

    @Singleton
    @Provides
    fun provideTransactionRemoteDataSource(service: ServiceMandiri):TransactionRemoteDataSource =
        TransactionRemoteDataSourceImpl(service)

    @Singleton
    @Provides
    fun provideTransactionRepository(transactionRemoteDataSource: TransactionRemoteDataSource):TransactionRepository=
        TransactionRepositoryimpl(transactionRemoteDataSource)
    @Singleton
    @Provides
    fun provideGetAllTransactionUseCase(transactionRepository: TransactionRepository):GetAllTransactionUseCase =
        GetAllTransactionUseCase(transactionRepository)
}