package com.example.serene

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        startActivity(Intent(this, Login_pae::class.java))
        finish()
    }
}