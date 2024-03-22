package com.example.serene.HealthyEatingActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.serene.R

class CleanCuisine : AppCompatActivity() {

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
        setContentView(R.layout.activity_clean_cuisine)

        articaltext =findViewById(R.id.articaltext)
        subtext =findViewById(R.id.subtextt)
        subtext2 =findViewById(R.id.subtext2)
        subtext3 =findViewById(R.id.subtext3)
        subtext4 =findViewById(R.id.subtext4)
        back =findViewById(R.id.back)

        back.setOnClickListener {
            onBackPressed()
        }

        articaltext.text = " CleanCuisine: Embracing a Wholesome Approach to Eating\n"

         subtext.text= " CleanCuisine goes beyond just what you eat—it's a holistic approach to nourishing your body and supporting your overall well-being. By embracing clean eating principles, you can fuel your body with wholesome, nutrient-rich foods that promote optimal health and vitality.\n" +
                "\n" +
                "At the core of CleanCuisine is the idea of prioritizing whole, minimally processed foods that are free from artificial additives, preservatives, and chemicals. This means choosing foods that are as close to their natural state as possible, such as fruits, vegetables, whole grains, lean proteins, and healthy fats.\n" +
                "\n" +
                "CleanCuisine also emphasizes the importance of balance and moderation in your eating habits. While it's important to nourish your body with nutritious foods, it's also essential to enjoy the foods you love in moderation. By finding a balance between nutritious foods and occasional indulgences, you can maintain a healthy relationship with food while still enjoying the pleasures of eating.\n" +
                "\n" +
                "Another key aspect of CleanCuisine is cooking meals at home using fresh, whole ingredients. By preparing your own meals, you can have more control over the ingredients and cooking methods used, allowing you to make healthier choices and avoid hidden sources of unhealthy additives."

               subtext3.text= " CleanCuisine: \n" +
                "\n" +
                "Emphasize clean eating principles by choosing foods that are minimally processed, free from artificial additives, and close to their natural state. Prioritize whole, nutrient-rich foods such as fruits, vegetables, whole grains, lean proteins, and healthy fats.\n" +
                "\n" +
                "Incorporate a variety of colorful fruits and vegetables into your meals to maximize your intake of vitamins, minerals, and antioxidants. Aim to fill half of your plate with vegetables at each meal to ensure you're getting plenty of fiber and essential nutrients.\n" +
                "\n" +
                "Choose lean sources of protein such as poultry, fish, tofu, tempeh, legumes, and nuts to support muscle growth and repair. Limit your intake of processed meats and fatty cuts of meat, which can be high in unhealthy fats and sodium.\n" +
                "\n" +
                "Include healthy fats in your diet such as avocados, nuts, seeds, and olive oil. These fats are essential for brain health, hormone production, and the absorption of fat-soluble vitamins.\n" +
                "\n" +
                "Minimize your intake of refined sugars, unhealthy fats, and processed foods, which can contribute to inflammation, weight gain, and chronic disease. Opt for natural sweeteners like honey, maple syrup, and dates when sweetening foods.\n" +
                "\n" +
                "Cook meals at home whenever possible using fresh, whole ingredients. Homemade meals give you more control over the ingredients and cooking methods used, allowing you to make healthier choices.\n" +
                "\n" +
                "Be mindful of portion sizes and avoid overeating, even with clean, healthy foods. Pay attention to your body's hunger and fullness cues and eat until you're satisfied, rather than stuffed.\n" +
                "\n" +
                "Stay hydrated by drinking plenty of water throughout the day. Water is essential for digestion, nutrient absorption, temperature regulation, and overall well-being.\n" +
                "\n" +
                "Practice moderation and balance in your eating habits, enjoying a wide variety of foods in appropriate portions. Allow yourself to indulge in your favorite treats occasionally while prioritizing nutrient-dense foods the majority of the time.\n" +
                "\n" +
                "Listen to your body and honor its signals of hunger and fullness. Eat when you're hungry and stop when you're satisfied, aiming for a balanced approach to eating that supports overall health and well-being.\n"

                subtext2.text=    "Emphasize clean eating principles by choosing foods that are minimally processed, free from artificial additives, and close to their natural state.\n" +
                "\n" +
                "Prioritize whole, nutrient-rich foods like fruits, vegetables, whole grains, lean proteins, and healthy fats.\n" +
                "\n" +
                "Limit your intake of refined sugars, unhealthy fats, and processed foods to support optimal health and well-being."

            subtext4.text=  "In addition to prioritizing whole, minimally processed foods, CleanCuisine also emphasizes the importance of mindful eating. This means paying attention to your body's hunger and fullness cues, as well as the taste, texture, and enjoyment of your food. By slowing down and savoring each bite, you can better appreciate the flavors and nourishment that whole foods provide.\n" +
                "\n" +
                "Ultimately, CleanCuisine is about nourishing your body with wholesome, nutrient-rich foods while minimizing your exposure to artificial additives and processed ingredients. By embracing the principles of clean eating and prioritizing whole, minimally processed foods, you can fuel your body with the nutrients it needs to thrive and support your overall health and well-being."+
                "\n"

    }
}