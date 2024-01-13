package com.e.mandiriapps.presentation.message.transactionstatus.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.mandiriapps.R
import com.e.mandiriapps.data.network.usecase.GetAllTransactionUseCase
import com.e.mandiriapps.model.TransactionStatusModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionStatusViewModel @Inject constructor(private val getAllTransactionUseCase: GetAllTransactionUseCase) :ViewModel() {
    private val _transactionStatusDatas = MutableLiveData<List<TransactionStatusModel>>()
    val transactionStatusDatas = _transactionStatusDatas
    private var remoteList :List<TransactionStatusModel> = listOf()

    fun updateData()=viewModelScope.launch{
        remoteList=getAllTransactionUseCase.getAllTransaction()
        _transactionStatusDatas.postValue(remoteList)
    }

    fun getAllTransaction():List<TransactionStatusModel>{
        return remoteList
    }

    fun filterdata(category: String):List<TransactionStatusModel>{
        return remoteList.filter {
            it.getTransactionTypeString() == category
        }
    }
}