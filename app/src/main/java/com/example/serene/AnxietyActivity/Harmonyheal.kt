package com.example.serene.AnxietyActivity

import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import com.airbnb.lottie.LottieAnimationView
import com.example.serene.R

class Harmonyheal : AppCompatActivity() {

    lateinit var playButton: Button
    lateinit var pauseButton: Button
    lateinit var rewind: Button
    lateinit var forward: Button
    lateinit var seekBar: SeekBar
    lateinit var i1: LottieAnimationView
    var isPlaying = false
    private val handler = Handler()
    val mp: MediaPlayer
        get() {
            TODO()
        }
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
        setContentView(R.layout.activity_harmonyheal)

        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.s1)

    }
}