package com.e.mandiriapps.presentation.promo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.e.mandiriapps.adapter.PromoAdapter
import com.e.mandiriapps.databinding.FragmentPromoBinding
import com.e.mandiriapps.model.PromoModel
import com.e.mandiriapps.presentation.basefragment.BaseFragment
import com.e.mandiriapps.presentation.promo.viewmodel.PromoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PromoFragment : BaseFragment<FragmentPromoBinding>() {

    private val promoViewModel:PromoViewModel by viewModels()
    override fun inflateBinding(): FragmentPromoBinding {
        return  FragmentPromoBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        promoViewModel.updateData(resources)
        observePromoData()
    }

    private fun observePromoData(){
        promoViewModel.promoData.observe(viewLifecycleOwner){
            setDataToPromoViewPager(it)
        }
    }

    private fun setDataToPromoViewPager(list: List<PromoModel>){
        val viewPager=binding.vpComponentPromo.vpPromo
        viewPager.adapter=PromoAdapter(requireActivity(),list)
    }

}