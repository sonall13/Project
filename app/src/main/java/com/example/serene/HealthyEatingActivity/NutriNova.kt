package com.example.serene.HealthyEatingActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.serene.R

class NutriNova : AppCompatActivity() {

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
        setContentView(R.layout.activity_nutri_nova)

        a1=findViewById(R.id.a1)
        a2=findViewById(R.id.a2)
        a3=findViewById(R.id.a3)
        a4=findViewById(R.id.a4)


        a1.text = "Prepare most of your meals at home using whole or minimally processed foods." +
                "Make an eating plan each week" +
                " – this is the key to fast, easy meal preparation.Choose recipes with plenty of vegetables and fruit." +
                " Your goal is to fill half your plate with vegetables and fruit at every meal. "

        a2.text = "Avoid sugary drinks and instead drink water. Lower-fat," +
                " unsweetened milk is also a good way to stay hydrated." +
                " Keep a reusable water bottle in your purse or car so you can fill up wherever you are going."


        a3.text = "Eat smaller meals more often. Eat at least three meals a day with snacks in between. " +
                "When you wait too long to eat you are more likely to make unhealthy food choices. "

        a4.text= "1. Eating lots of vegetables and fruit\n" +
                "2. Choosing whole grain foods\n" +
                "3. Eating protein foods\n" +
                "4. Limiting highly and ultra-processed foods\n" +
                "5. Making water your drink of choice"




    }
}