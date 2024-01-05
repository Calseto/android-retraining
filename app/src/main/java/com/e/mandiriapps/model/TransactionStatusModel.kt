package com.e.mandiriapps.model

import android.media.Image
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransactionStatusModel(
    val date:String,
    val transactionType:Int,
    val titleTransaction:String,
    val subtitleTransaction:String,
    val status:Int,
    val nominal:String,
    val image: Int
):Parcelable{
    // Tanyain Besok
    fun getTransactionTypeString():String{
        when(transactionType){
            Type.Emoney.value-> return "E-Money"
            Type.Qris.value-> return "Qris"
            Type.Wallet.value-> return "Wallet"
            Type.Bill.value-> return "Bill"
            Type.Transfer.value-> return "Transfer"
            else -> return ""
        }
    }
}

enum class Status(val value:Int){
    Failed(2),
    Success(1),
    Pending(0)
}

enum class Type(val value:Int){
    Emoney(0),
    Qris(1),
    Wallet(2),
    Bill(4),
    Transfer(5)
}