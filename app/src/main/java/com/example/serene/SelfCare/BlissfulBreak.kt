package com.example.serene.SelfCare

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.serene.R

class BlissfulBreak : AppCompatActivity() {
    lateinit var  selfcareartical : TextView
    lateinit var  selfcareartical2 : TextView
    lateinit var  back : ImageButton
    @SuppressLint("SetTextI18n")
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
        setContentView(R.layout.activity_blissful_break)

        selfcareartical =findViewById(R.id.selfcareartical)
        selfcareartical2 =findViewById(R.id.selfcareartical2)
        back =findViewById(R.id.back)

        back.setOnClickListener {
            onBackPressed()
        }

        selfcareartical.text = " StressBusterHub: How to Adult Without Losing Your Mind\n"

          selfcareartical2.text= "Life can be overwhelming at times, with work, relationships, and responsibilities piling up faster than we can keep track. That's where StressBusterHub comes in—a one-stop destination for effective strategies to manage stress and maintain our sanity in the face of life's challenges.\n" +
                "\n" +
                "At the core of StressBusterHub is the belief that stress is a natural part of life, but it doesn't have to control us. By learning how to effectively manage stress and build resilience, we can navigate life's ups and downs with grace and ease.\n" +
                "\n" +
                "So, what are some strategies for managing stress? One approach is to practice mindfulness meditation, which involves focusing your attention on the present moment and letting go of worries about the past or future. By incorporating mindfulness into your daily routine, you can reduce stress, improve concentration, and enhance overall well-being.\n" +
                "\n" +
                "Another effective stress-busting strategy is to engage in regular physical activity, whether it's going for a walk, hitting the gym, or practicing yoga. Exercise has been shown to reduce stress hormones and increase the production of endorphins, chemicals in the brain that act as natural painkillers and mood elevators.\n" +
                "\n" +
                "In addition to mindfulness and exercise, StressBusterHub also encourages individuals to prioritize self-care activities that bring joy and relaxation. Whether it's indulging in a hobby, spending time with loved ones, or simply taking a few moments to breathe deeply and recharge, self-care is essential for managing stress and maintaining a healthy balance in life.\n" +
                "\n" +
                "Ultimately, StressBusterHub is about empowering individuals to take control of their stress and reclaim their peace of mind. By learning effective stress management strategies and prioritizing self-care, we can navigate life's challenges with resilience and grace, knowing that we have the tools we need to thrive.\n" +
                "\n"

    }
}