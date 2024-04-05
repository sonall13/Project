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
        val patten = "[a-z[0-9._-]]+@[gmail]+\\.+com"
        val pass = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%])(?=\\S+$).{4,}$"

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

        Notifications.createNotificationChannel(this)
        Notifications.setNotificationAlarm(this,18,46,0,0)
        Notifications.setDailyNotificationAlarm(this,18,46,0,1)

        // Check if Android M or higher
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Show alert dialog to the user saying a separate permission is needed
            // Launch the settings activity if the user prefers
            val myIntent: Intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
            startActivity(myIntent)
        }*/

        Handler(Looper.getMainLooper()).postDelayed({
            if(sp.getBoolean("status",false))
            {
//                startActivity(Intent(this,Home_page::class.java))
//                finish()
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