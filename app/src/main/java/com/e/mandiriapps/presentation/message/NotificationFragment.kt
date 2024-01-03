package com.e.mandiriapps.presentation.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.e.mandiriapps.R
import com.e.mandiriapps.adapter.NotifAdapter
import com.e.mandiriapps.databinding.FragmentNotificationBinding
import com.e.mandiriapps.model.NotificationModel

class NotificationFragment :Fragment(){
    var _binding : FragmentNotificationBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvNotification.adapter=NotifAdapter(setDummyNotifData())
    }

    private fun setDummyNotifData():MutableList<NotificationModel> {
        return mutableListOf<NotificationModel>(
            NotificationModel("Transaksi Tarik Tunai Berhasil", resources.getString(R.string.lorem_ipsum),"9 Nov"),
            NotificationModel("Transaksi Tarik Tunai Berhasil", resources.getString(R.string.lorem_ipsum),"12 Nov"),
            NotificationModel("Token Siap Digunakan", resources.getString(R.string.lorem_ipsum),"3 Feb"),
            NotificationModel("Transaksi Tarik Tunai Berhasil", resources.getString(R.string.lorem_ipsum),"1 Jan"),
            NotificationModel("Token Siap Digunakan", resources.getString(R.string.lorem_ipsum),"15 Aug"),
            NotificationModel("Transaksi Tarik Tunai Berhasil", resources.getString(R.string.lorem_ipsum),"20 Nov")
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }
}