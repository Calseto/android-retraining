package com.e.mandiriapps.model

import android.media.Image

data class TransactionStatusModel(
    val date:String,
    val titleTransaction:String,
    val subtitleTransaction:String,
    val status:Int,
    val nominal:String,
    val image: Int
);

enum class Status(val value:Int){
    Failed(2),
    Success(1),
    Pending(0)
}