package com.example.serene.MeditationActivity

import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.serene.R

class Mantra : AppCompatActivity() {
    lateinit var play: Button
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
        setContentView(R.layout.activity_mantra)
        play = findViewById(R.id.play)
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.mt4)
        play.setOnClickListener {

            mp.start()
        }
//        mp = MediaPlayer.create(
//            this, R.raw.mt4
//        );
//
//
//        // Playing the music
//      fun musicplay()
//        {
//            mp.start();
//        }
//
//        // Pausing the music
//     fun musicpause(View v)
//        {
//            mp.pause();
//        }
//
//        // Stopping the music
//       fun musicstop(View v)
//        {
//            mp.stop();
//            mp= MediaPlayer.create(
//            this, R.raw.mt4
//        );
        }
    }


