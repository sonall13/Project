package com.example.serene.sleepHome

import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.serene.R

class Sleep_audio2 : AppCompatActivity() {
    lateinit var play: Button
    lateinit var pause: Button
    lateinit var back: ImageButton
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
        setContentView(R.layout.activity_sleep_audio2)

        play=findViewById(R.id.play)
        back=findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.sp2)
        play.setOnClickListener {

            mp.start()
        }
        pause=findViewById(R.id.pause)
        pause.setOnClickListener {

            mp.stop()
        }
    }
}