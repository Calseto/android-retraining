package com.e.mandiriapps.presentation.login

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import com.e.mandiriapps.databinding.ActivityLoginBinding
import com.e.mandiriapps.presentation.HomeActivity
import com.e.mandiriapps.presentation.RegisterActivity
import com.e.mandiriapps.presentation.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setTransparentStatusBar()

        checkIfAlreadyLogin()

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
        viewModel.toastMessage.observe(this){
            it.toToast()
        }
        viewModel.loginResult.observe(this){ result ->
            when (result) {
                LoginViewModel.LoginResult.EMPTY_PASSWORD -> {
                    binding.stvErrorPassMain.visibility = View.VISIBLE
                }
                LoginViewModel.LoginResult.INCORRECT_PASSWORD -> {
                    binding.stvErrorPassMain.visibility = View.VISIBLE
                }
                LoginViewModel.LoginResult.CORRECT_PASSWORD -> {
                    binding.stvErrorPassMain.visibility = View.GONE
                    viewModel.saveNewToken()
                    handleNavigation()
                }
            }
        }
    }

    private fun checkIfAlreadyLogin(){
        viewModel.checkTokenAvailability()
        viewModel.tokenAvaibility.observe(this){avaibility->
            if (avaibility){
                handleNavigation()
            }
        }
    }

    private fun String.toToast(){
        toastMaker(this)
    }


    private fun setTransparentStatusBar() {
        window.apply {
            // Enable transparent status bar
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT

            // Optional: Handle dark icons on light background
            decorView.systemUiVisibility =
                decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        }
    }
}