package com.example.serene.HealthyEatingActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.serene.R

class WholesomeWell : AppCompatActivity() {
    lateinit var  articaltext : TextView
    lateinit var  subtext :TextView
    lateinit var  subtext2 :TextView
    lateinit var  subtext3 :TextView
    lateinit var  subtext4 :TextView
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
        setContentView(R.layout.activity_wholesome_well)

        articaltext =findViewById(R.id.articaltext)
        subtext =findViewById(R.id.subtextt)
        subtext2 =findViewById(R.id.subtext2)
        subtext3 =findViewById(R.id.subtext3)
        subtext4 =findViewById(R.id.subtext4)
        back =findViewById(R.id.back)

        back.setOnClickListener {
            onBackPressed()
        }

        articaltext.text =  "\n  WholesomeWell: Nourishing Your Body with Nutrient-Rich Foods\n"

             subtext.text=   "In today's fast-paced world, prioritizing our health and well-being is more important than ever. One key aspect of leading a healthy lifestyle is ensuring that we nourish our bodies with wholesome, nutrient-rich foods that provide the fuel and nutrients needed to thrive. The WholesomeWell approach to eating emphasizes the consumption of whole, minimally processed foods that are packed with essential vitamins, minerals, fiber, and antioxidants.\n" +
                "\n" +
                "At the core of the WholesomeWell philosophy is the idea of basing our meals on a foundation of nutrient-dense foods such as fruits, vegetables, whole grains, lean proteins, and healthy fats. These foods not only provide the essential nutrients our bodies need to function optimally but also offer a wide range of health benefits, including improved energy levels, enhanced immune function, and better overall health.\n"

              subtext2.text=  "Tips : How WholesomeWell Follow\n"+
                "\n" +
                " -> Base your meals on whole, minimally processed foods like fruits, vegetables, whole grains, lean proteins, and healthy fats.\n" +
                " -> Prioritize nutrient-rich foods to nourish your body and provide essential vitamins, minerals, and antioxidants.\n" +
                " -> Practice portion control and mindful eating to avoid overeating and promote satisfaction with your meals.\n"

               subtext3.text= " 1. One of the key principles of WholesomeWell eating is to prioritize quality over quantity. Instead of focusing solely on calorie counting or restricting certain food groups, we strive to choose foods that are high in nutritional value and support our health goals. By filling our plates with a colorful array of fruits and vegetables, lean proteins, and whole grains, we can ensure that we're providing our bodies with the nutrients they need to thrive.\n" +
                "\n" +
                " 2. In addition to prioritizing nutrient-rich foods, WholesomeWell eating also emphasizes the importance of balance and moderation. While it's important to nourish our bodies with healthy foods, it's also essential to enjoy the foods we love in moderation. By finding a balance between nutritious foods and occasional indulgences, we can maintain a healthy relationship with food while still enjoying the pleasures of eating.\n" +
                "\n" +
                " 3. Cook at home whenever possible using fresh ingredients. Homemade meals give you greater control over the ingredients and cooking methods, allowing you to make healthier choices.\n" +
                "\n" +
                " 4.Be mindful of added sugars, unhealthy fats, and excessive salt in processed foods. Limit your intake of sugary snacks, fried foods, and highly processed snacks to support overall health.\n" +
                "\n" +
                " 5. Stay hydrated by drinking plenty of water throughout the day. Water is essential for digestion, nutrient absorption, temperature regulation, and overall well-being.\n" +
                "\n" +
                " 6. Focus on balanced meals that include a combination of carbohydrates, proteins, and fats. Aim for a variety of nutrient sources to ensure you're meeting your body's needs.\n" +
                "\n" +
                " 7. Include sources of healthy fats in your diet such as avocados, nuts, seeds, and olive oil. Healthy fats support heart health, brain function, and hormone balance.\n" +
                "\n" +
                " 8. Practice mindful eating by slowing down and savoring each bite. Pay attention to the taste, texture, and aroma of your food to enhance the eating experience and prevent overeating.\n" +
                "\n" +
                " 9. Listen to your body and honor its signals of hunger and fullness. Eat when you're hungry and stop when you're satisfied, aiming for a balanced approach to eating that promotes overall well-being."
                "\n" +
                "Ultimately, adopting a WholesomeWell approach to eating is about nourishing our bodies from the inside out and prioritizing our health and well-being. By choosing whole, nutrient-rich foods, practicing balance and moderation, and prioritizing quality over quantity, we can fuel our bodies with the nutrients they need to thrive and live our best lives.\n" +
                "\n"

    }

}