package com.e.mandiriapps.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.e.mandiriapps.R
import com.e.mandiriapps.adapter.EwalletAdapter
import com.e.mandiriapps.adapter.SavingDepositAdapter
import com.e.mandiriapps.adapter.ServiceMenuAdapter
import com.e.mandiriapps.databinding.FragmentHomeBinding
import com.e.mandiriapps.helper.SharedPref
import com.e.mandiriapps.model.EwalletModel
import com.e.mandiriapps.model.SavingDepositModel
import com.e.mandiriapps.model.ServiceModel


class HomeFragment : Fragment() {
    var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var  savingDepositAdapter: SavingDepositAdapter
    private lateinit var serviceMenuAdapter: ServiceMenuAdapter
    private lateinit var  listSavingDeposit:MutableList<SavingDepositModel>
    private lateinit var  listServiceMenu:MutableList<ServiceModel>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvEwalletHome.recyclerView.adapter= EwalletAdapter(setDummyWalletList())

        listSavingDeposit=setDummySavingList()
        savingDepositAdapter=SavingDepositAdapter(listSavingDeposit)
        binding.rvSavingHome.recyclerView.adapter= savingDepositAdapter

        setupViewService()
        updateSavingDeposit()
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
            SavingDepositModel(savingName = "Tabungan", accountNumber = "123456789",
                R.drawable.card1
            ),
            SavingDepositModel(savingName = "Tabungan Rencana", accountNumber = "987654321",
                R.drawable.card1
            ),
            SavingDepositModel(savingName = "Deposito", accountNumber = "837495734",
                R.drawable.card1
            ),
            SavingDepositModel(savingName = "Giro", accountNumber = "387420039", R.drawable.card1),
            SavingDepositModel(savingName = "Tabungan Goib", accountNumber = "696969696",
                R.drawable.card1
            )

        )
    }
    private fun setDummyServiceList():MutableList<ServiceModel>{
        return mutableListOf(
            ServiceModel(R.drawable.livin_logo,"Transfer\nRupiah"),
            ServiceModel(R.drawable.livin_logo,"Bayar"),
            ServiceModel(R.drawable.livin_logo,"Top-up"),
            ServiceModel(R.drawable.livin_logo,"e-money"),
            ServiceModel(R.drawable.livin_logo,"Sukha"),
            ServiceModel(R.drawable.livin_logo,"Transfer\nValas"),
            ServiceModel(R.drawable.livin_logo,"QR Terima\nTransfer"),
            ServiceModel(R.drawable.livin_logo,"QR Bayar"),
            ServiceModel(R.drawable.livin_logo,"Tap to Pay"),
            ServiceModel(R.drawable.livin_logo,"Investasi"),
            ServiceModel(R.drawable.livin_logo,"Layanan Cabang"),
            ServiceModel(R.drawable.livin_logo,"Setor Tarik"),


            )
    }

    private fun setupViewService(){
        listServiceMenu=setDummyServiceList()
        serviceMenuAdapter= ServiceMenuAdapter(listServiceMenu)
        binding.rvServiceMenu.gvServiceMenu.adapter= serviceMenuAdapter
        serviceMenuAdapter.setOnClickMenu {
            Toast.makeText(context,it.menuTitle, Toast.LENGTH_SHORT).show()
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

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}