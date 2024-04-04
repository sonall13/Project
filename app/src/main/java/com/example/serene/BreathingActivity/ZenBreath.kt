package com.example.serene.BreathingActivity

import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import com.airbnb.lottie.LottieAnimationView
import com.example.serene.AllFunctionsClass
import com.example.serene.R

class ZenBreath : AppCompatActivity() {
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
        setContentView(R.layout.activity_zen_breath)

        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.a5)

        playButton = findViewById(R.id.playButton)
        pauseButton = findViewById(R.id.pauseButton)
        rewind = findViewById(R.id.rewind)
        forward = findViewById(R.id.forward)
        seekBar = findViewById(R.id.seekBar)
        val animationView = findViewById<LottieAnimationView>(R.id.i1)

        val maxDuration = mp.duration
        seekBar.max = maxDuration
        var w = AllFunctionsClass()

        rewind.setOnClickListener {

            w.rewind1(mp, seekBar, rewind)
        }

        forward.setOnClickListener {
            w.forword1(seekBar, mp)
        }

        mp.setOnPreparedListener {
            seekBar.max = mp.duration
        }

        val runnable = object : Runnable {
            override fun run() {
                seekBar.progress = mp.currentPosition
                handler.postDelayed(this, 1000) // Update every second
            }
        }
        handler.postDelayed(runnable, 0)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                w.method1(mp, progress, fromUser)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                isPlaying = w.method2(mp)
            }

            //
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                isPlaying = w.method3(mp, isPlaying)
            }
        })

        var animationProgress = 0f
        var animationIsPlaying = false

        playButton.setOnClickListener {
            animationIsPlaying = w.paly1(
                mp,
                playButton,
                pauseButton,
                animationIsPlaying,
                animationProgress,
                animationView
            )

        }
        pauseButton.setOnClickListener {

            val result = w.pause1(
                mp,
                playButton,
                pauseButton,
                animationView
            )
            animationProgress = result.first
            animationIsPlaying = result.second

        }

    }
}