package com.e.mandiriapps

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.e.mandiriapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        handleLogin(binding)

        }
    private fun handleNavigation(){
        val intent = Intent(this,UserInfoActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun handleLogin(binding:ActivityMainBinding){
        val text = binding.edtTxtPass.text
        val btn = binding.btnSubmit
        btn.setOnClickListener {
            if(text.isEmpty()){
                binding.stvErrorPass.visibility= View.VISIBLE
                Toast.makeText(applicationContext,"harap isi password", Toast.LENGTH_SHORT).show()
            }else if(text.toString()!="password123"){
                binding.stvErrorPass.visibility= View.VISIBLE
                Toast.makeText(applicationContext,"password salah", Toast.LENGTH_SHORT).show()
            }else{
                binding.stvErrorPass.visibility= View.GONE
                Toast.makeText(applicationContext,"selamat anda berhasil login", Toast.LENGTH_SHORT).show()
                handleNavigation()
            }
        }
    }
}