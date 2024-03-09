package com.example.serene.MentalHealthCategorys

import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.serene.R


class Anxiety : AppCompatActivity() {

    lateinit var circle_obj : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anxiety)

        circle_obj =findViewById(R.id.circle_obj)

        val animation: Animation =
            AnimationUtils.loadAnimation(this, R.anim.breathanim)
        animation.duration = 1000
        circle_obj.animation = animation


        val fadeIn: Animation = AlphaAnimation(1f, 0f)
        fadeIn.interpolator = AccelerateInterpolator()
        fadeIn.startOffset = 500
        fadeIn.duration = 1000
        circle_obj.setAnimation(fadeIn)

    }
}