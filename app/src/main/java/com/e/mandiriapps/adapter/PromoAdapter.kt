package com.e.mandiriapps.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.e.mandiriapps.model.PromoModel
import com.e.mandiriapps.presentation.itemfragment.PromoItemFragment

class PromoAdapter(
    fragmentActivity: FragmentActivity,
    private val data: List<PromoModel>
) : FragmentStateAdapter(fragmentActivity){

    override fun getItemCount():Int = data.size

    override fun createFragment(position: Int): Fragment {
        return PromoItemFragment.newInstance(data[position])
    }
}