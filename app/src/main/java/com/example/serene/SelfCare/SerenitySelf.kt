package com.example.serene.SelfCare

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.serene.R

class SerenitySelf : AppCompatActivity() {
    lateinit var  selfcareartical : TextView
    lateinit var  back : ImageButton
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
        setContentView(R.layout.activity_serenity_self)

        selfcareartical =findViewById(R.id.selfcareartical)
        back =findViewById(R.id.back)

        back.setOnClickListener {
            onBackPressed()
        }

        selfcareartical.text = "StressEase: Keep Calm and Carry On\n" +
                "\n" +
                "Life can throw us curveballs when we least expect it, leaving us feeling stressed, overwhelmed, and out of sorts. That's where StressEase comes in—a beacon of calm in a sea of chaos, offering practical tips and techniques to help you keep calm and carry on, no matter what life throws your way.\n" +
                "\n" +
                "At the heart of StressEase is the belief that we all have the power to manage stress and build resilience in the face of adversity. By learning how to recognize and respond to stress in healthy ways, we can navigate life's challenges with grace and ease.\n" +
                "\n" +
                "One effective strategy for managing stress is to practice deep breathing exercises, which can help activate the body's relaxation response and promote a sense of calm and well-being. Simply take a few moments to close your eyes, inhale deeply through your nose, and exhale slowly through your mouth, focusing on the sensation of your breath as it enters and leaves your body.\n" +
                "\n" +
                "Another helpful technique for managing stress is to engage in regular physical activity, such as going for a walk, practicing yoga, or dancing to your favorite music. Exercise has been shown to reduce stress hormones and increase the production of endorphins, chemicals in the brain that act as natural mood lifters.\n" +
                "\n" +
                "In addition to deep breathing and exercise, StressEase also encourages individuals to prioritize self-care activities that promote relaxation and well-being. Whether it's taking a warm bath, spending time in nature, or practicing mindfulness meditation, self-care is essential for managing stress and maintaining a healthy balance in life.\n" +
                "\n" +
                "Ultimately, StressEase is about empowering individuals to take control of their stress and reclaim their sense of calm and well-being. By learning effective stress management techniques and prioritizing self-care, we can navigate life's challenges with resilience and grace, knowing that we have the tools we need to thrive.\n" +
                "\n"
    }
}