package com.example.serene

import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.localnotificationdemo.Notifications


class SplaseScreen : AppCompatActivity() {
    companion object {
        lateinit var sp: SharedPreferences
        lateinit var edit: SharedPreferences.Editor

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splase_screen)
        sp = getSharedPreferences("name", MODE_PRIVATE)
        edit = sp.edit()



        Handler(Looper.getMainLooper()).postDelayed({
            if(sp.getBoolean("status",false))
            {
//
                startActivity(Intent(this,Home_page::class.java))
                finish()
            }
            else {
                startActivity(Intent(this, SliderView::class.java))
                finish()
            }
        }, 2000)
    }
}