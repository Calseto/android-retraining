package com.e.mandiriapps.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.e.mandiriapps.adapter.MassageTabAdapter
import com.e.mandiriapps.databinding.FragmentMessageBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MessageFragment : Fragment() {
    var _binding : FragmentMessageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMessageBinding.inflate(layoutInflater)

        val viewPager: ViewPager2 = binding.viewPagerMessage
        val tabLayout: TabLayout = binding.tabNavMessage

        val adapter = MassageTabAdapter(requireActivity())
        viewPager.adapter = adapter

        // Connect TabLayout with ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Notifications"
                1 -> "Status Transaksi"
                else -> null
            }
        }.attach()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}