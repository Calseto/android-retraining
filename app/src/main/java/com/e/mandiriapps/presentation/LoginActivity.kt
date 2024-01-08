package com.e.mandiriapps.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.e.mandiriapps.databinding.ActivityLoginBinding
import com.e.mandiriapps.helper.SharedPref
import java.util.UUID

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        sharedPref = SharedPref(context = this@LoginActivity)
        checkTokenAvailability()

        handleLogin(binding)
        handleRegister(binding)


        }

    private fun toastMaker(text:String){
        Toast.makeText(applicationContext,text, Toast.LENGTH_SHORT).show()
    }
    private fun handleNavigation(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
    private  fun handleRegister(binding: ActivityLoginBinding){
        binding.btnRegisterMain.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun handleLogin(binding:ActivityLoginBinding){
        val text = binding.edtTxtPassMain.text
        val btn = binding.btnLoginMain
        btn.setOnClickListener {
            if(text.isEmpty()){
                binding.stvErrorPassMain.visibility.apply {
                    View.VISIBLE
                }
                toastMaker("harap isi password")
            }else if(text.toString()!="pass"){
                binding.stvErrorPassMain.visibility.apply {
                    View.VISIBLE
                }
                toastMaker("password salah")
            }else{
                binding.stvErrorPassMain.visibility.apply {
                    View.GONE
                }
                toastMaker("selamat anda berhasil login")
                handleNavigation()
                val dummyToken:String = UUID.randomUUID().toString()
                sharedPref.saveToken(dummyToken)
            }
        }
    }
    private fun checkTokenAvailability(){
        val token = sharedPref.getToken()
        if (!token.isEmpty()){
            handleNavigation()
        }
    }
}