package com.example.serene.HealthyEatingActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.serene.R

class CleanCuisine : AppCompatActivity() {

    lateinit var a1 : TextView
    lateinit var a2 : TextView
    lateinit var a3 : TextView
    lateinit var a4 : TextView

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

        a1=findViewById(R.id.a1)
        a2=findViewById(R.id.a2)
        a3=findViewById(R.id.a3)
        a4=findViewById(R.id.a4)

        a1.text = "Salt\n" +
                "Too much salt is bad for you. It can\n" +
                "increase your risk of high blood\n" +
                "pressure, heart disease and stroke.\n" +
                "You should have no more than 6 grams of\n" +
                "salt a day. That’s about 1 level teaspoon."

        a2.text = "\n" +
                "Sugar\n" +
                "Sugar is high in ‘empty calories’.\n" +
                "These provide you with energy but\n" +
                "none of the vitamins, nutrients or\n" +
                "minerals you need.\n" +
                "Sugar can lead to weight gain and increase\n" +
                "your risk of Type 2 diabetes, heart disease,\n" +
                "stroke and tooth decay. "

        a3.text = "Starchy foods\n" +
                "Choose wholegrain or high\n" +
                "fibre varieties of starchy foods\n" +
                "whenever possible, for example,\n" +
                "wholemeal bread and brown rice.\n" +
                "Starchy foods should make\n" +
                "up about one third of the\n" +
                "food you eat each day."

        a4.text = "Aim to eat something\n" +
                "starchy at each mealtime.\n" +
                "Starchy foods (or\n" +
                "carbohydrates) are foods\n" +
                "like potatoes, bread, rice,\n" +
                "pasta and cereals.\n" +
                " always including vegetables in meals;\n" +
                " eating fresh fruit and raw vegetables as snacks;\n" +
                " eating fresh fruit and vegetables that are in season; and\n" +
                " eating a variety of fruit and vegetables."

    }
}