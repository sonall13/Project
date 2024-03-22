package com.example.serene.SelfCare

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.serene.Home_page
import com.example.serene.R

class CalmCoCoon : AppCompatActivity() {
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
        setContentView(R.layout.activity_calm_co_coon)

        selfcareartical =findViewById(R.id.selfcareartical)
        back =findViewById(R.id.back)

        back.setOnClickListener {
          onBackPressed()
        }

        selfcareartical.text= " ChilloutCove: Finding Tranquility in Self-Care\n" +
                "\n" +
                "In the hustle and bustle of modern life, finding moments of tranquility and relaxation can seem like a distant dream. However, amidst the chaos, there exists a sanctuary known as ChilloutCove—a haven where individuals can escape the stresses of daily life and immerse themselves in the soothing embrace of self-care.\n" +
                "\n" +
                "ChilloutCove is not just a physical location; it is a state of mind—a space where individuals can prioritize their well-being and recharge their batteries. Whether it's sinking into a luxurious bubble bath infused with essential oils, curling up with a good book and a cup of herbal tea, or simply basking in the warm glow of candlelight, ChilloutCove offers endless opportunities for relaxation and rejuvenation.\n" +
                "\n" +
                "But ChilloutCove is more than just a place to unwind; it's a philosophy—a commitment to self-care and self-love. In today's fast-paced world, it's all too easy to neglect our own needs in favor of meeting the demands of others. However, by carving out time for ourselves and indulging in activities that bring us joy and peace, we can replenish our energy reserves and face life's challenges with renewed strength and resilience.\n" +
                "\n" +
                "So how can you create your own ChilloutCove? Start by carving out a dedicated space in your home where you can escape the hustle and bustle of daily life—a cozy corner adorned with plush pillows, soft blankets, and soothing décor. Next, fill your space with items that bring you comfort and joy—whether it's your favorite scented candles, a collection of calming essential oils, or a playlist of relaxing music.\n" +
                "\n" +
                "Once you've created your own ChilloutCove, be sure to make time for regular visits. Whether it's a few minutes each day or a longer retreat on the weekends, prioritize self-care and give yourself permission to relax and unwind. Remember, self-care is not selfish—it's essential. By nurturing your own well-being, you'll be better equipped to show up as your best self in all areas of your life.\n" +
                "\n" +
                "In conclusion, ChilloutCove is more than just a place—it's a mindset, a philosophy, and a commitment to self-care. By embracing the principles of ChilloutCove and making self-care a priority in your life, you can create a sanctuary of tranquility and find peace amidst the chaos of everyday life."+
                "\n"
    }
}