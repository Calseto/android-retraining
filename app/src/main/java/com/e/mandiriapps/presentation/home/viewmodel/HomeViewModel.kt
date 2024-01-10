package com.e.mandiriapps.presentation.home.viewmodel

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.mandiriapps.R
import com.e.mandiriapps.model.EwalletModel
import com.e.mandiriapps.model.NotificationModel
import com.e.mandiriapps.model.SavingDepositModel
import com.e.mandiriapps.model.ServiceModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor():ViewModel() {
    private val _notifDataWallet = MutableLiveData<List<EwalletModel>>()
    val notifDataWallet : LiveData<List<EwalletModel>> get() = _notifDataWallet

    private val _notifDataSavingDeposit = MutableLiveData<List<SavingDepositModel>>()
    val notifDataSavingDeposit : LiveData<List<SavingDepositModel>> get() = _notifDataSavingDeposit

    private val _notifDataService = MutableLiveData<List<ServiceModel>>()
    val notifDataService : LiveData<List<ServiceModel>> get() = _notifDataService

    fun updateData()=viewModelScope.launch{
        _notifDataWallet.postValue(setDummyWalletList())
        _notifDataSavingDeposit.postValue(setDummySavingList())
        _notifDataService.postValue(setDummyServiceList())
    }
    private fun setDummyWalletList():MutableList<EwalletModel>{
        return mutableListOf(
            EwalletModel(name = "Gojek", image = R.drawable.livin_logo,5000, isConnected = true),
            EwalletModel(name = "Shopee", image = R.drawable.livin_logo,5000, isConnected = false),
            EwalletModel(name = "Dana", image = R.drawable.livin_logo,5000, isConnected = true),
            EwalletModel(name = "LinkAja", image = R.drawable.livin_logo,5000, isConnected =false)
        )
    }
    private fun setDummySavingList():MutableList<SavingDepositModel>{
        return mutableListOf(
            SavingDepositModel(savingName = "Tabungan", accountNumber = "123456789",
                R.drawable.card1
            ),
            SavingDepositModel(savingName = "Tabungan Rencana", accountNumber = "987654321",
                R.drawable.card1
            ),
            SavingDepositModel(savingName = "Deposito", accountNumber = "837495734",
                R.drawable.card1
            ),
            SavingDepositModel(savingName = "Giro", accountNumber = "387420039", R.drawable.card1),
            SavingDepositModel(savingName = "Tabungan Goib", accountNumber = "696969696",
                R.drawable.card1
            )

        )
    }
    private fun setDummyServiceList():MutableList<ServiceModel>{
        return mutableListOf(
            ServiceModel(R.drawable.livin_logo,"Transfer\nRupiah"),
            ServiceModel(R.drawable.livin_logo,"Bayar"),
            ServiceModel(R.drawable.livin_logo,"Top-up"),
            ServiceModel(R.drawable.livin_logo,"e-money"),
            ServiceModel(R.drawable.livin_logo,"Sukha"),
            ServiceModel(R.drawable.livin_logo,"Transfer\nValas"),
            ServiceModel(R.drawable.livin_logo,"QR Terima\nTransfer"),
            ServiceModel(R.drawable.livin_logo,"QR Bayar"),
            ServiceModel(R.drawable.livin_logo,"Tap to Pay"),
            ServiceModel(R.drawable.livin_logo,"Investasi"),
            ServiceModel(R.drawable.livin_logo,"Layanan Cabang"),
            ServiceModel(R.drawable.livin_logo,"Setor Tarik"),


            )
    }

}