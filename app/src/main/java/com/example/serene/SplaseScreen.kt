package com.example.serene

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.serene.Login.Login_pae

class SplaseScreen : AppCompatActivity() {

    companion object {

        lateinit var sp: SharedPreferences
        lateinit var edit: SharedPreferences.Editor
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splase_screen)

        sp = getSharedPreferences("name", MODE_PRIVATE)
        edit = sp.edit()

        Handler(Looper.getMainLooper()).postDelayed({
            if(sp.getBoolean("status",false))
            {
                startActivity(Intent(this, SliderView::class.java))
                finish()
            }
            else {
                startActivity(Intent(this, Home_page::class.java))
                finish()
            }
        }, 2000)

    }

}