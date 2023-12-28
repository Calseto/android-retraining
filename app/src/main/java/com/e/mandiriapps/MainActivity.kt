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
        handleRegister(binding)

        }

    private fun toastMaker(text:String){
        Toast.makeText(applicationContext,text, Toast.LENGTH_SHORT).show()
    }
    private fun handleNavigation(){
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
    private  fun handleRegister(binding: ActivityMainBinding){
        binding.btnRegisterFromLogin.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun handleLogin(binding:ActivityMainBinding){
        val text = binding.edtTxtPass.text
        val btn = binding.btnSubmit
        btn.setOnClickListener {
            if(text.isEmpty()){
                binding.stvErrorPass.visibility.apply {
                    View.VISIBLE
                }
                toastMaker("harap isi password")
            }else if(text.toString()!="password123"){
                binding.stvErrorPass.visibility.apply {
                    View.VISIBLE
                }
                toastMaker("password salah")
            }else{
                binding.stvErrorPass.visibility.apply {
                    View.GONE
                }
                toastMaker("selamat anda berhasil login")
                handleNavigation()
            }
        }
    }
}