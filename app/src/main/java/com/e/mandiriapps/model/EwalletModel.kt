package com.e.mandiriapps.model

import  android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class EwalletModel(
    val name: String,
    val image: Int,
    val balance: Int,
    var isConnected: Boolean
) : Parcelable;