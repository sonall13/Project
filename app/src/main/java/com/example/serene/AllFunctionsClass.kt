package com.example.serene

import android.media.MediaPlayer
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import com.airbnb.lottie.LottieAnimationView

public class AllFunctionsClass {


    fun isValidEmail(email: String): Boolean {
        val emailRegex = "[a-z[0-9._-]]+@[gmail]+\\.+com"
        return email.matches(emailRegex.toRegex())
    }

    fun isValidPassword(password: String): Boolean {
        val passwordRegex =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
        return password.matches(passwordRegex.toRegex())
    }

    fun rewind1(mp: MediaPlayer, seekBar: SeekBar, rewind: Button) {
        val currentProgress = seekBar.progress
        val newProgress = currentProgress - 10000 // Rewind by 10 seconds
        if (newProgress >= 0) {
            seekBar.progress = newProgress
            mp.seekTo(newProgress)
        } else {
            seekBar.progress = 0
            mp.seekTo(0)
        }
    }

    fun forword1(seekBar: SeekBar, mp: MediaPlayer) {
        val currentProgress = seekBar.progress
        val newProgress = currentProgress + 10000 // Forward by 10 seconds
        if (newProgress <= seekBar.max) {
            seekBar.progress = newProgress
            mp.seekTo(newProgress)
        } else {
            seekBar.progress = seekBar.max
            mp.seekTo(seekBar.max)
        }
    }

    fun paly1(
        mp: MediaPlayer,
        playButton: Button,
        pauseButton: Button,
        animationIsPlaying: Boolean,
        animationProgress: Float,
        animationView: LottieAnimationView,
    ): Boolean {
        mp.start()
        playButton.visibility = View.INVISIBLE
        pauseButton.visibility = View.VISIBLE

        if (!animationIsPlaying) {
            animationView.progress = animationProgress
            animationView.resumeAnimation()
        }
        return true
    }

    fun pause1(
        mp: MediaPlayer,
        playButton: Button,
        pauseButton: Button,
        animationView: LottieAnimationView,
    ) : Pair<Float, Boolean> {
        mp.pause()
        playButton.visibility = View.VISIBLE
        pauseButton.visibility = View.INVISIBLE

        val progress = animationView.progress
        animationView.pauseAnimation()
        return Pair(progress, false)
    }


        fun method1(mp: MediaPlayer,progress: Int, fromUser: Boolean) {
            if (fromUser) {
                mp.seekTo(progress)
            }
        }

        fun method2(mp: MediaPlayer) :Boolean{
            // Pause audio playback while user is interacting with SeekBar
            mp.pause()
            if (mp.isPlaying) {
                mp.pause()
            }
            return true
        }

        fun method3(mp: MediaPlayer,isPlaying : Boolean) :Boolean{
            // Resume audio playback when user stops interacting with SeekBar
            mp.start()
            if (isPlaying) {
                mp.start()
            }
            return false

        }

    }

