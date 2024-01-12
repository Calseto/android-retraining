package com.e.mandiriapps.data.model

import com.google.gson.annotations.SerializedName

data class TransactionResponse (
    @SerializedName("id")
    val id:String?,

    @SerializedName("image_url")
    val image_url:String,

    @SerializedName("metode_trf")
    val metodeTransfer:String,

    @SerializedName("name")
    val Name:String,

    @SerializedName("nominal_saldo")
    val mnominalSaldo:String?,

    @SerializedName("flag_debit_credit")
    val debitCard:Int,

)