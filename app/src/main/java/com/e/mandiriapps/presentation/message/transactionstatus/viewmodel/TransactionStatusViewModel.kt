package com.e.mandiriapps.presentation.message.transactionstatus.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.mandiriapps.R
import com.e.mandiriapps.model.TransactionStatusModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionStatusViewModel @Inject constructor() :ViewModel() {
    private val _TransactionStatusDatas = MutableLiveData<List<TransactionStatusModel>>()
    val TransactionStatusDatas = _TransactionStatusDatas

    fun updateData()=viewModelScope.launch{
        _TransactionStatusDatas.postValue(populateDataTransactionStatus())
    }

    fun filterdata(category: String):List<TransactionStatusModel>{
        return populateDataTransactionStatus().filter {
            it.getTransactionTypeString().equals(
                category
            )
        }
    }
    private fun populateDataTransactionStatus(): MutableList<TransactionStatusModel> {
        return mutableListOf(
            TransactionStatusModel(
                date = "3 Januari 2024",
                titleTransaction = "E-Money",
                subtitleTransaction = "603019280192",
                nominal = "Rp 100.000",
                transactionType = 0,
                status = 1,
                image = R.drawable.wallet_alt_svgrepo_com
            ),
            TransactionStatusModel(
                date = "5 Februari 2024",
                titleTransaction = "Wallet",
                subtitleTransaction = "Dibatalkan oleh pengirim",
                nominal = "Rp 0",
                transactionType = 2,
                status = 2,
                image = R.drawable.wallet_alt_svgrepo_com
            ),TransactionStatusModel(
                date = "15 April 2024",
                titleTransaction = "Qris Bayar",
                subtitleTransaction = "Bebek Sinjay - Jln. Petojo No.69",
                nominal = "Rp 1.000.000",
                transactionType = 1,
                status = 0,
                image = R.drawable.wallet_alt_svgrepo_com
            ),TransactionStatusModel(
                date = "1 Januari 2024",
                titleTransaction = "E-Money",
                subtitleTransaction = "603019280192",
                nominal = "Rp 100.000",
                transactionType = 0,
                status = 1,
                image = R.drawable.wallet_alt_svgrepo_com
            ),
            TransactionStatusModel(
                date = "3 September 2024",
                titleTransaction = "Qris Bayar",
                subtitleTransaction = "Stik Kentang - Jln Tanah Abang Timur No.420",
                nominal = "Rp 20.000",
                transactionType = 1,
                status = 1,
                image = R.drawable.wallet_alt_svgrepo_com
            ),TransactionStatusModel(
                date = "10 Juli 2024",
                titleTransaction = "Qris Bayar",
                subtitleTransaction = "Bebek Sinjay - Jln. Petojo No.69",
                nominal = "Rp 500.000",
                transactionType = 1,
                status = 1,
                image = R.drawable.wallet_alt_svgrepo_com
            )
        )
    }
}