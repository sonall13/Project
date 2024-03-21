package com.example.serene.HealthyEatingActivity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.serene.R

class CleanEatsCorner : AppCompatActivity() {
    lateinit var  articaltext :TextView
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
        setContentView(R.layout.activity_clean_eats_corner)

        articaltext =findViewById(R.id.articaltext)

        articaltext.text = "1. WholesomeWell: Nourishing Your Body with Nutrient-Rich Foods\n" +
                "\n" +
                "In today's fast-paced world, prioritizing our health and well-being is more important than ever. One key aspect of leading a healthy lifestyle is ensuring that we nourish our bodies with wholesome, nutrient-rich foods that provide the fuel and nutrients needed to thrive. The WholesomeWell approach to eating emphasizes the consumption of whole, minimally processed foods that are packed with essential vitamins, minerals, fiber, and antioxidants.\n" +
                "\n" +
                "At the core of the WholesomeWell philosophy is the idea of basing our meals on a foundation of nutrient-dense foods such as fruits, vegetables, whole grains, lean proteins, and healthy fats. These foods not only provide the essential nutrients our bodies need to function optimally but also offer a wide range of health benefits, including improved energy levels, enhanced immune function, and better overall health.\n" +
                "\n" +
                "Tips : How WholesomeWell Follow\n"+
               "\n" +
                "* Base your meals on whole, minimally processed foods like fruits, vegetables, whole grains, lean proteins, and healthy fats.\n" +
                "* Prioritize nutrient-rich foods to nourish your body and provide essential vitamins, minerals, and antioxidants.\n" +
                "* Practice portion control and mindful eating to avoid overeating and promote satisfaction with your meals.\n"+
                "\n" +
                "One of the key principles of WholesomeWell eating is to prioritize quality over quantity. Instead of focusing solely on calorie counting or restricting certain food groups, we strive to choose foods that are high in nutritional value and support our health goals. By filling our plates with a colorful array of fruits and vegetables, lean proteins, and whole grains, we can ensure that we're providing our bodies with the nutrients they need to thrive.\n" +
                "\n" +
                "In addition to prioritizing nutrient-rich foods, WholesomeWell eating also emphasizes the importance of balance and moderation. While it's important to nourish our bodies with healthy foods, it's also essential to enjoy the foods we love in moderation. By finding a balance between nutritious foods and occasional indulgences, we can maintain a healthy relationship with food while still enjoying the pleasures of eating.\n" +
                "\n" +
                "Ultimately, adopting a WholesomeWell approach to eating is about nourishing our bodies from the inside out and prioritizing our health and well-being. By choosing whole, nutrient-rich foods, practicing balance and moderation, and prioritizing quality over quantity, we can fuel our bodies with the nutrients they need to thrive and live our best lives.\n" +
                "\n"



    }
}