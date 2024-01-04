package com.e.mandiriapps.presentation.message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.e.mandiriapps.R
import com.e.mandiriapps.adapter.TransactionStatusAdapter
import com.e.mandiriapps.databinding.FragmentHomeBinding
import com.e.mandiriapps.databinding.FragmentTransactionStatusBinding
import com.e.mandiriapps.model.TransactionStatusModel
import com.e.mandiriapps.presentation.detailtransaction.TransactionDetailActivity

class TransactionStatusFragment :Fragment() {
    var _binding : FragmentTransactionStatusBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransactionStatusBinding.inflate(layoutInflater)

        setupViewTransactionStatus()
        return binding.root
    }

    private fun navigateToDetailTransaction(){
        val intent=Intent(context,TransactionDetailActivity::class.java)
        startActivity(intent)
    }

    private fun setupViewTransactionStatus(){

        val onClick:()->Unit={
            navigateToDetailTransaction()
        }
        binding.componentTransactionStatus
            .rvTransactionStatus.adapter=TransactionStatusAdapter(populateDataTransactionStatus(),onClick)
    }

    private fun populateDataTransactionStatus(): MutableList<TransactionStatusModel> {
        return mutableListOf(
            TransactionStatusModel(
                date = "3 Januari 2024",
                titleTransaction = "Anda mendapatkan uang tunai",
                subtitleTransaction = "Uang tunai yang anda dapatkan sebesar 10.000.000 Rupiah",
                nominal = "Rp 200.000",
                status = 1,
                image = R.drawable.wallet_alt_svgrepo_com
            ),
            TransactionStatusModel(
                date = "5 Februari 2024",
                titleTransaction = "Anda mendapatkan uang tunai",
                subtitleTransaction = "Dibatalkan oleh pengirim",
                nominal = "Rp 0",
                status = 2,
                image = R.drawable.wallet_alt_svgrepo_com
            ),TransactionStatusModel(
                date = "5 Februari 2024",
                titleTransaction = "Anda mendapatkan uang tunai",
                subtitleTransaction = "Uang tunai yang anda dapatkan sebesar 10.000.000 Rupiah",
                nominal = "Rp 1.000.000",
                status = 0,
                image = R.drawable.wallet_alt_svgrepo_com
            )
            )
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }

}