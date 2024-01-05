package com.e.mandiriapps.presentation.message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.e.mandiriapps.R
import com.e.mandiriapps.adapter.TransactionStatusAdapter
import com.e.mandiriapps.databinding.FragmentHomeBinding
import com.e.mandiriapps.databinding.FragmentTransactionStatusBinding
import com.e.mandiriapps.model.TransactionStatusModel
import com.e.mandiriapps.model.Type
import com.e.mandiriapps.presentation.detailtransaction.TransactionDetailActivity

class TransactionStatusFragment :Fragment() {
    var _binding : FragmentTransactionStatusBinding? = null
    private var _adapter: TransactionStatusAdapter? = null
    private var _data: MutableList<TransactionStatusModel>? = null
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


    private fun setupViewTransactionStatus() {
        _data = populateDataTransactionStatus()
        _adapter = TransactionStatusAdapter(
            data = populateDataTransactionStatus(),
            onClickMenu = {model->
                TransactionDetailActivity.navigateToDetailTransaction(
                    activity = requireActivity(),
                    data = model
                )
            }
        )
        binding.componentTransactionStatus
            .rvTransactionStatus.adapter= _adapter
    }

    private fun populateDataTransactionStatus(): MutableList<TransactionStatusModel> {
        return mutableListOf(
            TransactionStatusModel(
                date = "3 Januari 2024",
                titleTransaction = "E-Money",
                subtitleTransaction = "603019280192",
                nominal = "Rp 100.000",
                transactionType = 0,
                status = 1,
                image = R.drawable.wallet_alt_svgrepo_com
            ),
            TransactionStatusModel(
                date = "5 Februari 2024",
                titleTransaction = "Wallet",
                subtitleTransaction = "Dibatalkan oleh pengirim",
                nominal = "Rp 0",
                transactionType = 2,
                status = 2,
                image = R.drawable.wallet_alt_svgrepo_com
            ),TransactionStatusModel(
                date = "15 April 2024",
                titleTransaction = "Qris Bayar",
                subtitleTransaction = "Bebek Sinjay - Jln. Petojo No.69",
                nominal = "Rp 1.000.000",
                transactionType = 1,
                status = 0,
                image = R.drawable.wallet_alt_svgrepo_com
            ),TransactionStatusModel(
                date = "1 Januari 2024",
                titleTransaction = "E-Money",
                subtitleTransaction = "603019280192",
                nominal = "Rp 100.000",
                transactionType = 0,
                status = 1,
                image = R.drawable.wallet_alt_svgrepo_com
            ),
            TransactionStatusModel(
                date = "3 September 2024",
                titleTransaction = "Qris Bayar",
                subtitleTransaction = "Stik Kentang - Jln Tanah Abang Timur No.420",
                nominal = "Rp 20.000",
                transactionType = 1,
                status = 1,
                image = R.drawable.wallet_alt_svgrepo_com
            ),TransactionStatusModel(
                date = "10 Juli 2024",
                titleTransaction = "Qris Bayar",
                subtitleTransaction = "Bebek Sinjay - Jln. Petojo No.69",
                nominal = "Rp 500.000",
                transactionType = 1,
                status = 1,
                image = R.drawable.wallet_alt_svgrepo_com
            )
            )
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = arrayOf("Semua","E-Money","Qris","Wallet")
        binding.spFilterTransaction.adapter =
            ArrayAdapter(
                requireContext(),
                com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
                items
            )
        binding.spFilterTransaction.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val spinnerValue = parent?.getItemAtPosition(position).toString()
                    binding.tvFilter.text=spinnerValue
                    if (position==0) {
                        _adapter?.filterTransactionData(populateDataTransactionStatus())
                    }else{
                        populateDataTransactionStatus().filter {
                            it.getTransactionTypeString().equals(
                                spinnerValue
                            )
                        }.also { data ->
                            _adapter?.filterTransactionData(data.toMutableList())
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }

}