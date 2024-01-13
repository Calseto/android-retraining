package com.e.mandiriapps.presentation.home

import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.e.mandiriapps.adapter.EwalletAdapter
import com.e.mandiriapps.adapter.SavingDepositAdapter
import com.e.mandiriapps.adapter.ServiceMenuAdapter
import com.e.mandiriapps.databinding.FragmentHomeBinding
import com.e.mandiriapps.model.EwalletModel
import com.e.mandiriapps.model.SavingDepositModel
import com.e.mandiriapps.model.ServiceModel
import com.e.mandiriapps.presentation.basefragment.BaseFragment
import com.e.mandiriapps.presentation.home.viewmodel.HomeViewModel



class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel:HomeViewModel by viewModels()

    private lateinit var  ewalletAdapter: EwalletAdapter
    private lateinit var  listEwallet:List<EwalletModel>

    private lateinit var  savingDepositAdapter: SavingDepositAdapter
    private lateinit var  listSavingDeposit:List<SavingDepositModel>

    private lateinit var serviceMenuAdapter: ServiceMenuAdapter
    private lateinit var  listServiceMenu:List<ServiceModel>

    override fun inflateBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        viewModel.updateData()
        setupRVEwallet()
        setupRVSavingDeposit()
        setupRVService()
    }

    private fun setupRVEwallet(){
        viewModel.notifDataWallet.observe(viewLifecycleOwner){
            listEwallet=it
            ewalletAdapter= EwalletAdapter(listEwallet)
            binding.rvEwalletHome.recyclerView.adapter= ewalletAdapter
        }

    }
    private fun setupRVSavingDeposit(){
        viewModel.notifDataSavingDeposit.observe(viewLifecycleOwner){
            listSavingDeposit=it
            savingDepositAdapter= SavingDepositAdapter(listSavingDeposit)
            binding.rvSavingHome.recyclerView.adapter= savingDepositAdapter

            updateSavingDeposit()
        }


    }
    private fun setupRVService(){
        viewModel.notifDataService.observe(viewLifecycleOwner){
            listServiceMenu=it
            serviceMenuAdapter= ServiceMenuAdapter(listServiceMenu)
            binding.rvServiceMenu.gvServiceMenu.adapter= serviceMenuAdapter

            serviceMenuAdapter.setOnClickMenu {
                Toast.makeText(context,it.menuTitle, Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun updateSavingDeposit(){
        binding.rvSavingHome.apply {
            btnShowMore.isVisible = listSavingDeposit.size>2
            btnShowMore.setOnClickListener{
                savingDepositAdapter.updateQuantitySize(listSavingDeposit.size)
                btnShowMore.visibility=View.GONE
                btnShowLess.visibility=View.VISIBLE
            }
            btnShowLess.setOnClickListener{
                savingDepositAdapter.updateQuantitySize(2)
                btnShowMore.visibility=View.VISIBLE
                btnShowLess.visibility=View.GONE
            }
        }
    }

}