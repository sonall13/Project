package com.example.serene.Vitalvibe1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.serene.R
import com.bumptech.glide.Glide;
class AuraActivator : AppCompatActivity() {


    lateinit var imagg1 : ImageView
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
        setContentView(R.layout.activity_aura_activator)
        imagg1 = findViewById(R.id.imagg1)

        Glide.with(this).asGif().load(R.raw.marjaryasana).into(imagg1);
//
//
//        Glide.with(this).asGif().load(R.raw.test123).into(imagge);

    }
}