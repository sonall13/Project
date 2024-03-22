package com.example.serene.SelfCare

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.serene.R

class TranquiTouches : AppCompatActivity() {
    lateinit var  selfcareartical : TextView
    lateinit var  back : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Make the activity fullscreen
//        window.requestFeature(Window.FEATURE_NO_TITLE)
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = getColor(R.color.statusbarcolor)
        }
        setContentView(R.layout.activity_tranqui_touches)

        selfcareartical =findViewById(R.id.selfcareartical)
        back =findViewById(R.id.back)

        back.setOnClickListener {
            onBackPressed()
        }
    }
}