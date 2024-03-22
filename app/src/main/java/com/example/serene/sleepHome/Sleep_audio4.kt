package com.example.serene.sleepHome

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.serene.R

class Sleep_audio4 : AppCompatActivity() {
    lateinit var play: Button
    lateinit var pause: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sleep_audio4)
        play=findViewById(R.id.play)
        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.sp4)
        play.setOnClickListener {

            mp.start()
        }
        pause=findViewById(R.id.pause)
        pause.setOnClickListener {

            mp.stop()
        }
    }
}