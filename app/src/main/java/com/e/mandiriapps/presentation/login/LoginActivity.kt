package com.e.mandiriapps.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.e.mandiriapps.databinding.ActivityLoginBinding
import com.e.mandiriapps.helper.SharedPref
import com.e.mandiriapps.presentation.HomeActivity
import com.e.mandiriapps.presentation.RegisterActivity
import com.e.mandiriapps.presentation.home.viewmodel.HomeViewModel
import com.e.mandiriapps.presentation.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID
import javax.inject.Inject
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPref: SharedPref
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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
        val btn = binding.btnLoginMain
        btn.setOnClickListener {
            val text = binding.edtTxtPassMain.text.toString()
            viewModel.checkPassword(text)
        }

        viewModel.loginResult.observe(this){ result ->
            when (result) {
                LoginViewModel.LoginResult.EMPTY_PASSWORD -> {
                    binding.stvErrorPassMain.visibility = View.VISIBLE
                    toastMaker("Harap isi password")
                }
                LoginViewModel.LoginResult.INCORRECT_PASSWORD -> {
                    binding.stvErrorPassMain.visibility = View.VISIBLE
                    toastMaker("Password salah")
                }
                LoginViewModel.LoginResult.CORRECT_PASSWORD -> {
                    binding.stvErrorPassMain.visibility = View.GONE
                    toastMaker("Selamat, Anda berhasil login")
                    handleNavigation()
                }
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