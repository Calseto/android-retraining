package com.e.mandiriapps.presentation.detailtransaction

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.e.mandiriapps.databinding.ActivityDetailTransactionBinding
import com.e.mandiriapps.databinding.ItemTransactionBinding
import com.e.mandiriapps.model.Status
import com.e.mandiriapps.model.TransactionStatusModel
import com.e.mandiriapps.model.Type

class TransactionDetailActivity : AppCompatActivity() {

    lateinit var binding:ActivityDetailTransactionBinding
    lateinit var data: TransactionStatusModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentdata()
        setupView()
    }

    private fun getIntentdata(){
        data=intent.getParcelableExtra(DATA_TRANSACTION)!!
    }

    private fun setupView(){
        binding.componentToolbarTrans.apply {
            tvToolbarTitle.text=""
            ivBack.setOnClickListener{
                onBackPressed()
            }
        }
        binding.componentDetailTransTop.apply {
            when(data.transactionType){
                Type.Emoney.value->tvTransTypeDetailTrans.text="Top-Up"
                Type.Wallet.value->tvTransTypeDetailTrans.text="Top-Up"
                Type.Qris.value->tvTransTypeDetailTrans.text="QR Bayar"
                Type.Bill.value ->tvTransTypeDetailTrans.text="Bayar"
                Type.Transfer.value ->tvTransTypeDetailTrans.text="Transfer Rupiah"
            }
            when(data.status) {
                Status.Success.value -> tvStatusDetailTrans.text="Transaksi Berhasil"
                Status.Failed.value -> tvStatusDetailTrans.text="Transaksi Gagal"
                Status.Pending.value -> tvStatusDetailTrans.text="Transaksi Pending"
            }
            tvDateDetailTrans.text=data.date
        }
        binding.componentDetailTransMid.apply {
            when(data.transactionType){
                Type.Emoney.value->tvTypeDetailTrans.text="E-Money"
                Type.Wallet.value->tvTypeDetailTrans.text="Penyedia Jasa"
                Type.Qris.value->tvTypeDetailTrans.text="QR Bayar"
                Type.Bill.value ->tvTypeDetailTrans.text="Penyedia Jasa"
                Type.Transfer.value ->tvTypeDetailTrans.text="Penerima"
            }
            tvReceiverNameDetailTrans.text=data.titleTransaction
            tvReceiverAccDetailTrans.text=data.subtitleTransaction
            tvNominalTransDetail.text=data.nominal
        }
    }
    companion object{
        const val DATA_TRANSACTION="dataTransaction"

        fun navigateToDetailTransaction(activity: Activity,data:TransactionStatusModel){
            val intent=Intent(activity,TransactionDetailActivity::class.java)
            intent.putExtra(DATA_TRANSACTION,data)
            activity.startActivity(intent)
        }
    }
}