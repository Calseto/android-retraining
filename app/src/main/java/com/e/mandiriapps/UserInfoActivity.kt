package com.e.mandiriapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.e.mandiriapps.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUserInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}