package com.e.mandiriapps.presentation.message.transactionstatus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.e.mandiriapps.adapter.TransactionStatusAdapter
import com.e.mandiriapps.databinding.FragmentTransactionStatusBinding
import com.e.mandiriapps.model.TransactionStatusModel
import com.e.mandiriapps.presentation.detailtransaction.TransactionDetailActivity
import com.e.mandiriapps.presentation.message.transactionstatus.viewmodel.TransactionStatusViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionStatusFragment :Fragment() {
    var _binding : FragmentTransactionStatusBinding? = null
    private var _adapter: TransactionStatusAdapter? = null
    private lateinit var _data: List<TransactionStatusModel>
    private val binding get() = _binding!!

    private val viewModel : TransactionStatusViewModel by viewModels()
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
        viewModel.updateData()
        viewModel.TransactionStatusDatas.observe(viewLifecycleOwner){
            _data=it
            _adapter = TransactionStatusAdapter(
                data = _data,
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
                        _adapter?.updateData(_data)
                    }else{
                        val filteredData= viewModel.filterdata(spinnerValue)
                        _adapter?.updateData(filteredData)
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