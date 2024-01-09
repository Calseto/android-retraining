package com.e.mandiriapps.presentation.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.e.mandiriapps.adapter.NotifAdapter
import com.e.mandiriapps.databinding.FragmentNotificationBinding
import com.e.mandiriapps.model.NotificationModel
import com.e.mandiriapps.presentation.viewmodel.NotificationViewModel

class NotificationFragment :Fragment(){
    private var _binding : FragmentNotificationBinding? = null
    private val binding get() = _binding!!

    private val viewModel:NotificationViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationBinding.inflate(layoutInflater)
        setupViewModel()
        return binding.root
    }

    private fun setupViewModel(){
        viewModel.apply {
            updateData(resources)
            notifData.observe(viewLifecycleOwner){
                binding.rvNotification.adapter=NotifAdapter(it)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }
}