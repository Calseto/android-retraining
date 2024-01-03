package com.e.mandiriapps.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.e.mandiriapps.presentation.RegisterActivity.Companion.KEY_AlAMAT_VALUE
import com.e.mandiriapps.presentation.RegisterActivity.Companion.KEY_NAME_VALUE
import com.e.mandiriapps.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUserInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var name = intent.getStringExtra(KEY_NAME_VALUE)
        var address = intent.getStringExtra(KEY_AlAMAT_VALUE)
        binding.textViewName.text=name
        binding.textViewAddress.text=address
    }
}