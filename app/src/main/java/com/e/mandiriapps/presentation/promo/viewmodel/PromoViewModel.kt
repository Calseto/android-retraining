package com.e.mandiriapps.presentation.promo.viewmodel

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.mandiriapps.R
import com.e.mandiriapps.model.NotificationModel
import com.e.mandiriapps.model.PromoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PromoViewModel @Inject constructor():ViewModel(){
    private val _promoData = MutableLiveData<List<PromoModel>>()
    val promoData : LiveData<List<PromoModel>> get() = _promoData


    fun updateData(resources: Resources){
        _promoData.postValue(setDummyData(resources))

    }

    private fun setDummyData(resources: Resources):MutableList<PromoModel> {
        return mutableListOf<PromoModel>(
            PromoModel(
                title="Burger King",
                desc = resources.getString(R.string.lorem_ipsum),
                dueDate = "8 Mei 2150",
                image="https://i.ibb.co/wKpjPqR/promo1.png"
            ),
            PromoModel(
                title="Mc Donald",
                desc = resources.getString(R.string.lorem_ipsum),
                dueDate = "8 Mei 2150",
                image="https://i.ibb.co/WVDdwb2/promo2.jpg"
            )
        )
    }
}