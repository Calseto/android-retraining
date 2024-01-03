package com.e.mandiriapps.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.e.mandiriapps.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        check()

    }
    private fun check(){
        val nameVal = binding.edtTxtNamaRegister.edtTxtRegister.text
        val umurVal = binding.edtTxtUmurRegister.edtTxtRegister.text
        val alamatVal = binding.edtTxtAlamatRegister.edtTxtRegister.text
        val genderVal = binding.edtTxtGenderRegister.edtTxtRegister.text
        binding.buttonRegister.setOnClickListener{
            if(nameVal.isEmpty() || alamatVal.isEmpty()||umurVal.isEmpty()||genderVal.isEmpty()){
                Toast.makeText(this,"data harus diisi semua",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"data telah diisi",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, UserInfoActivity::class.java)
                intent.putExtra(KEY_NAME_VALUE,nameVal.toString())
                intent.putExtra(KEY_UMUR_VALUE,umurVal.toString())
                intent.putExtra(KEY_AlAMAT_VALUE,alamatVal.toString())
                intent.putExtra(KEY_GENDER_VALUE,genderVal.toString())
                navigate(intent)
            }
        }


    }

    private fun navigate(intent: Intent){
        startActivity(intent)
        finish()
    }
    companion object{
        const val KEY_NAME_VALUE ="key_name_value"
        const val KEY_UMUR_VALUE ="key_umur_value"
        const val KEY_AlAMAT_VALUE ="key_alamat_value"
        const val KEY_GENDER_VALUE ="key_gender_value"
    }
}