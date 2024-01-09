package com.e.mandiriapps.presentation.viewmodel

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.mandiriapps.R
import com.e.mandiriapps.model.NotificationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor():ViewModel() {
    private val _notifData = MutableLiveData<List<NotificationModel>>()
    val notifData : LiveData<List<NotificationModel>> get() = _notifData


    fun updateData(resources:Resources){
        _notifData.postValue(setDummyData(resources))
    }

    private fun setDummyData(resources:Resources):MutableList<NotificationModel> {
        return mutableListOf<NotificationModel>(
            NotificationModel("Transaksi Tarik Tunai Berhasil", resources.getString(R.string.lorem_ipsum),"9 Nov"),
            NotificationModel("Transaksi Tarik Tunai Berhasil", resources.getString(R.string.lorem_ipsum),"12 Nov"),
            NotificationModel("Token Siap Digunakan", resources.getString(R.string.lorem_ipsum),"3 Feb"),
            NotificationModel("Transaksi Tarik Tunai Berhasil", resources.getString(R.string.lorem_ipsum),"1 Jan"),
            NotificationModel("Token Siap Digunakan", resources.getString(R.string.lorem_ipsum),"15 Aug"),
            NotificationModel("Transaksi Tarik Tunai Berhasil", resources.getString(R.string.lorem_ipsum),"20 Nov")
        )
    }
}