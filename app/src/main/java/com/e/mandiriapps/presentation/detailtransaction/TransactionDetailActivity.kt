package com.e.mandiriapps.presentation.detailtransaction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.e.mandiriapps.databinding.ActivityDetailTransactionBinding
import com.e.mandiriapps.databinding.ItemTransactionBinding

class TransactionDetailActivity : AppCompatActivity() {

    lateinit var binding:ActivityDetailTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}