package com.example.serene.AffirmationActivity

import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.serene.R

class AffirmArcade : AppCompatActivity() {
    lateinit var play: Button

    lateinit var pause: Button
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
        setContentView(R.layout.activity_affirm_arcade)
        play=findViewById(R.id.play)
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.af1)
        play.setOnClickListener {

            mp.start()
        }
        pause=findViewById(R.id.pause)
        pause.setOnClickListener {

            mp.stop()
        }
    }
}