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
import com.e.mandiriapps.helper.SharedPref
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        sharedPref = SharedPref(context = this@MainActivity)
        checkTokenAvailability()

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
        binding.btnRegisterMain.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun handleLogin(binding:ActivityMainBinding){
        val text = binding.edtTxtPassMain.text
        val btn = binding.btnLoginMain
        btn.setOnClickListener {
            if(text.isEmpty()){
                binding.stvErrorPassMain.visibility.apply {
                    View.VISIBLE
                }
                toastMaker("harap isi password")
            }else if(text.toString()!="password123"){
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