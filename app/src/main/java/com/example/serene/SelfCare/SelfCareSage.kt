package com.example.serene.SelfCare

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.serene.R

class SelfCareSage : AppCompatActivity() {
    lateinit var  selfcareartical : TextView
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
        setContentView(R.layout.activity_self_care_sage)

        selfcareartical =findViewById(R.id.selfcareartical)
        back =findViewById(R.id.back)

        back.setOnClickListener {
            onBackPressed()
        }

        selfcareartical.text = " RelaxationRealm: The Lazy Person's Guide to Self-Care\n" +
                "\n" +
                "Sometimes, the thought of self-care can feel overwhelming, especially when life gets busy and our schedules are packed to the brim. That's where RelaxationRealm comes in—a sanctuary for those who crave relaxation but don't have the time or energy for elaborate self-care routines.\n" +
                "\n" +
                "At the heart of RelaxationRealm is the belief that self-care doesn't have to be complicated or time-consuming. In fact, even the simplest of activities can have a profound impact on our well-being. Whether it's taking a few deep breaths, stretching your muscles, or enjoying a cup of tea, RelaxationRealm offers a variety of easy, low-effort self-care practices that anyone can incorporate into their daily routine.\n" +
                "\n" +
                "But RelaxationRealm isn't just about lazy self-care—it's also about prioritizing rest and relaxation in a world that glorifies busyness and productivity. By taking time to slow down and recharge, we can replenish our energy reserves and show up as our best selves in all areas of our lives.\n" +
                "\n" +
                "So how can you incorporate RelaxationRealm into your own life? Start by identifying simple self-care activities that bring you joy and relaxation—whether it's reading a book, listening to music, or taking a leisurely walk in nature. Then, carve out time each day to indulge in these activities, even if it's just for a few minutes.\n" +
                "\n" +
                "Remember, self-care is not selfish—it's essential. By prioritizing rest and relaxation, you can recharge your batteries and show up as your best self in all areas of your life. So go ahead, embrace your inner sloth, and let RelaxationRealm be your guide to a life filled with peace, joy, and tranquility."+
                "\n"
    }
}