package com.e.mandiriapps.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.e.mandiriapps.R
import com.e.mandiriapps.databinding.ActivityHomeBinding
import com.e.mandiriapps.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity(){
    lateinit var binding: ActivityHomeBinding
    private lateinit var sharedPref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref= SharedPref(this)

        binding.bttomNavigation.setOnNavigationItemSelectedListener (onNavigationItemSelectedListener)
        if(savedInstanceState==null) binding.bttomNavigation.selectedItemId=R.id.navigationHome
    }



    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener {item ->
            when(item.itemId){
                R.id.navigationHome-> {
                    replaceFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationMessage-> {
                    replaceFragment(MessageFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationSettings-> {
                    replaceFragment(SettingsFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationPromo-> {
                    replaceFragment(PromoFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationLogOut-> {
                    logOut()
                    return@OnNavigationItemSelectedListener true
                }

                else->{return@OnNavigationItemSelectedListener true}
            }
        }

    private fun logOut() {
            sharedPref.clearToken()
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit()
    }
}