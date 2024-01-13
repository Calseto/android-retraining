package com.e.mandiriapps.presentation.message.transactionstatus

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.e.mandiriapps.adapter.TransactionStatusAdapter
import com.e.mandiriapps.databinding.FragmentTransactionStatusBinding
import com.e.mandiriapps.model.TransactionStatusModel
import com.e.mandiriapps.presentation.basefragment.BaseFragment
import com.e.mandiriapps.presentation.detailtransaction.TransactionDetailActivity
import com.e.mandiriapps.presentation.message.transactionstatus.viewmodel.TransactionStatusViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionStatusFragment :BaseFragment<FragmentTransactionStatusBinding>() {

    private var _adapter: TransactionStatusAdapter? = null
    private val viewModel : TransactionStatusViewModel by viewModels()

    override fun inflateBinding(): FragmentTransactionStatusBinding {
        return FragmentTransactionStatusBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        setupTransactionStatusSpinner()
        filterTransactionOnSpinnerChange()
        viewModel.updateData()
        observeForSpinnerChange()
    }

    private fun observeForSpinnerChange(){
        viewModel.transactionStatusDatas.observe(viewLifecycleOwner,::setTransactionData)

    }
    private fun setTransactionData(data:List<TransactionStatusModel>){
        _adapter = TransactionStatusAdapter(
            data = data,
            onClickMenu = {model->
                navigateToDetailTransaction(model)
            }
        )
        binding.componentTransactionStatus
            .rvTransactionStatus.adapter= _adapter
    }
    private fun navigateToDetailTransaction(model:TransactionStatusModel){
        TransactionDetailActivity.navigateToDetailTransaction(
            activity = requireActivity(),
            data = model
        )
    }

    private fun setupTransactionStatusSpinner(){
        val items = arrayOf("Semua","E-Money","Qris","Wallet")
        binding.spFilterTransaction.adapter =
            ArrayAdapter(
                requireContext(),
                com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
                items
            )
    }
    private fun filterTransactionOnSpinnerChange(){
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
                        _adapter?.updateData(viewModel.getAllTransaction())
                    }else{
                        val filteredData= viewModel.filterdata(spinnerValue)
                        _adapter?.updateData(filteredData)
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }
    }

}