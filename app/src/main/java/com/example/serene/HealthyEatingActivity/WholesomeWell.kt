package com.example.serene.HealthyEatingActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.serene.R

class WholesomeWell : AppCompatActivity() {

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
        setContentView(R.layout.activity_wholesome_well)


        a1=findViewById(R.id.a1)
        a2=findViewById(R.id.a2)
        a3=findViewById(R.id.a3)
        a4=findViewById(R.id.a4)

        a1.text = "This is one of the most important diet habits. Vegetables and fruit are packed with nutrients (antioxidants, vitamins, minerals and fibre) and help you maintain a healthy weight by keeping you full longer.\n" +
                "Fill half your plate with vegetables and fruit at every meal and snack."


        a2.text = "Eating a healthy, balanced diet is good for\n" +
                "your health.\n" +
                "By eating the right foods you can reduce your\n" +
                "risk of developing serious health conditions\n" +
                "like heart disease, stroke and diabetes.\n" +
                "Healthy eating is also good for your immune\n" +
                "system. It gives you energy and can help you\n" +
                "stay a healthy weight or lose weight if you\n" +
                "need to. \n"

      a3.text = "How can I eat more\n" +
              "healthily?\n" +
              "1 Base your meals on starchy foods\n" +
              "(carbohydrates) like rice, potatoes or pasta\n" +
              "(try to choose wholegrain, high-fibre\n" +
              "varieties)\n" +
              "2 Aim to eat at least 5 portions of different\n" +
              "fruit and vegetables a day\n" +
              "3 Eat more beans and pulses, and less red\n" +
              "and processed meats\n" +
              "4 Aim to eat at least 2 portions of fish a week,\n" +
              "including 1 portion of oily fish like mackerel"

       a4.text ="5 Limit saturated fat, salt and sugar\n" +
               "6 Do regular physical activity\n" +
               "7 Drink 6-8 glasses of non-alcoholic fluid\n" +
               "each day.\n" +
               "8 Always eat breakfast"
    }

}