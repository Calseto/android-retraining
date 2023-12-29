package com.e.mandiriapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.e.mandiriapps.adapter.EwalletAdapter
import com.e.mandiriapps.adapter.SavingDepositAdapter
import com.e.mandiriapps.databinding.ActivityHomeBinding
import com.e.mandiriapps.model.EwalletModel
import com.e.mandiriapps.model.SavingDepositModel

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rvEwalletHome.recyclerView.adapter= EwalletAdapter(setDummyWalletList())
        binding.rvSavingHome.recyclerView.adapter= SavingDepositAdapter(setDummySavingList())
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
            SavingDepositModel(savingName = "Tabungan ", accountNumber = "123456789",R.drawable.card1),
            SavingDepositModel(savingName = "Tabungan Rencana", accountNumber = "987654321",R.drawable.card1),
            SavingDepositModel(savingName = "Deposito", accountNumber = "837495734",R.drawable.card1),
            SavingDepositModel(savingName = "Giro", accountNumber = "387420039",R.drawable.card1),
            SavingDepositModel(savingName = "Tabungan Goib", accountNumber = "696969696",R.drawable.card1)

        )
    }

}