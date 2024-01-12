package com.e.mandiriapps.data.network.usecase

import com.e.mandiriapps.R
import com.e.mandiriapps.data.model.TransactionResponse
import com.e.mandiriapps.data.network.repo.TransactionRepository
import com.e.mandiriapps.model.TransactionStatusModel
import retrofit2.Response
import javax.inject.Inject

class GetAllTransactionUseCase @Inject constructor(private val transactionRepository: TransactionRepository) {
    suspend fun getAllTransaction(): List<TransactionStatusModel> {
        return mapToTransactionModel()
    }
    private suspend fun mapToTransactionModel():MutableList<TransactionStatusModel>{
        val listResponse = transactionRepository.getTransaction()
        val listMapped:MutableList<TransactionStatusModel> = mutableListOf()

        listResponse.body()?.forEach {
            val transactionStatusModel=TransactionStatusModel(
                date = "12 Oktober 2023",
                transactionType = 5,
                titleTransaction = "Transfer Rupiah",
                image = R.drawable.wallet_alt_svgrepo_com,
                nominal = it.mnominalSaldo,
                status = 1,
                subtitleTransaction = it.Name+" - "+it.debitCard
            )
            listMapped.add(transactionStatusModel)
        }
        return listMapped
    }
}