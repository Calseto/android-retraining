package com.e.mandiriapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PromoModel (
    val title:String,
    val desc:String,
    val dueDate:String,
    val image:String
): Parcelable