package com.example.serene.BreathingActivity

import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.serene.R

class ZenBreath : AppCompatActivity() {
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
        setContentView(R.layout.activity_zen_breath)
        play=findViewById(R.id.play)
        pause=findViewById(R.id.pause)
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.a5)
        play.setOnClickListener {

            mp.start()
        }
        pause.setOnClickListener {

            mp.stop()
        }
    }
}