package com.example.serene

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

//        startActivity(Intent(this, Login_pae::class.java))
//        finish()

        Handler(Looper.getMainLooper()).postDelayed({
            var Islogin =    sp.getBoolean("status",false)

            Log.e("S======", "onCreate: $Islogin" )

            if (Islogin){
                startActivity(Intent(this@SplaseScreen,Home_page::class.java))
                finish()

            }
            else{
                startActivity(Intent(this@SplaseScreen,Login_pae::class.java))
                finish()
            }
        },1500)


    }
}