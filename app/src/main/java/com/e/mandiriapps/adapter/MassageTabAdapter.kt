package com.e.mandiriapps.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.e.mandiriapps.presentation.message.notification.NotificationFragment
import com.e.mandiriapps.presentation.message.transactionstatus.TransactionStatusFragment

class MassageTabAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NotificationFragment()
            1 -> TransactionStatusFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}