package com.e.mandiriapps.presentation.message.notification

import androidx.fragment.app.viewModels
import com.e.mandiriapps.adapter.NotifAdapter
import com.e.mandiriapps.databinding.FragmentNotificationBinding
import com.e.mandiriapps.presentation.basefragment.BaseFragment
import com.e.mandiriapps.presentation.message.notification.viewmodel.NotificationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment :BaseFragment<FragmentNotificationBinding>(){

    private val viewModel: NotificationViewModel by viewModels()
    override fun inflateBinding(): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(layoutInflater)
    }


    override fun setupView(){
        viewModel.apply {
            updateData(resources)
            notifData.observe(viewLifecycleOwner){
                binding.rvNotification.adapter=NotifAdapter(it)
            }
        }
    }
}