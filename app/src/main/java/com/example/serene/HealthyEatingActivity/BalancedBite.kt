package com.example.serene.HealthyEatingActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.serene.R

class BalancedBite : AppCompatActivity() {
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
        setContentView(R.layout.activity_balanced_bite)

        articaltext =findViewById(R.id.articaltext)
        subtext =findViewById(R.id.subtextt)
        subtext2 =findViewById(R.id.subtext2)
        subtext3 =findViewById(R.id.subtext3)
        subtext4 =findViewById(R.id.subtext4)
        back =findViewById(R.id.back)


        back.setOnClickListener {
            onBackPressed()
        }
        articaltext.text =" BalancedBite: Finding Harmony in Your Eating Habits\n"

        subtext.text= "BalancedBite is all about finding harmony in your eating habits and embracing a balanced approach to nourishing your body. By focusing on balance, moderation, and variety, you can support your overall health and well-being while still enjoying the foods you love.\n" +
                "\n" +
                "At the heart of BalancedBite is the idea of prioritizing balance in your diet. This means including a variety of foods from all major food groups, including fruits, vegetables, whole grains, lean proteins, and healthy fats. By eating a balanced diet, you can ensure that you're getting all the essential nutrients your body needs to thrive.\n" +
                "\n" +
                "Another key principle of BalancedBite is practicing portion control and moderation. While it's important to enjoy a wide variety of foods, it's also essential to be mindful of portion sizes and avoid overeating. By listening to your body's hunger and fullness cues, you can better regulate your food intake and maintain a healthy weight."+
        "\n"
           subtext3.text =  " 1. Strive for balance in your diet by including a variety of foods from all major food groups: fruits, vegetables, whole grains, lean proteins, and healthy fats. Aim to create meals that offer a balance of carbohydrates, proteins, and fats to provide sustained energy and satiety.\n" +
                          "\n" +
                          " 2. Practice portion control by paying attention to serving sizes and avoiding oversized portions. Use smaller plates and bowls to help control portion sizes and prevent overeating.\n" +
                          "\n" +
                          " 3. Include sources of lean protein in your meals, such as poultry, fish, tofu, beans, lentils, and low-fat dairy products. Protein helps support muscle growth and repair, as well as feelings of fullness.\n" +
                          "\n" +
                          " 4. Incorporate a variety of colorful fruits and vegetables into your diet to ensure you're getting a wide range of vitamins, minerals, and antioxidants. Aim to fill half of your plate with fruits and vegetables at each meal.\n" +
                          "\n" +
                          " 5. Choose whole grains over refined grains to increase your intake of fiber and essential nutrients. Opt for options like brown rice, quinoa, whole wheat pasta, and oats, which provide sustained energy and promote digestive health.\n" +
                          "\n" +
                          " 6. Include sources of healthy fats in your diet, such as avocados, nuts, seeds, and olive oil. Healthy fats support heart health, brain function, and hormone balance.\n" +
                          "\n" +
                          " 7. Be mindful of your sugar intake and limit your consumption of sugary foods and beverages. Opt for natural sweeteners like honey, maple syrup, or fruit to satisfy your sweet tooth while minimizing added sugars.\n" +
                          "\n" +
                          " 8. Hydrate your body by drinking plenty of water throughout the day. Aim to drink at least 8 glasses of water daily, and more if you're active or in hot weather.\n" +
                          "\n" +
                          " 9. Practice mindful eating by paying attention to your body's hunger and fullness cues, as well as the taste, texture, and enjoyment of your food. Avoid distractions while eating and take the time to savor each bite.\n" +
                          "\n" +
                          " 10. Be flexible with your eating habits and allow for occasional indulgences. Focus on overall patterns of healthy eating rather than strict rules or restrictions, and remember that balance is key to maintaining a healthy lifestyle."

           subtext2.text=    "  -> Strive for balance and moderation in your eating habits, enjoying a wide variety of foods in appropriate portions.\n" +
                "\n" +
                "   -> Aim to include all major food groups in your meals, including fruits, vegetables, grains, proteins, and fats, to ensure you're getting a diverse range of nutrients.\n" +
                "\n" +
                "   -> Listen to your body's hunger and fullness cues, and eat mindfully to foster a healthy relationship with food.\n"

           subtext4.text =  "BalancedBite is also about listening to your body and honoring its needs. This means eating when you're hungry and stopping when you're satisfied, rather than adhering to strict rules or restrictions. By tuning in to your body's signals and eating mindfully, you can develop a healthier relationship with food and better support your overall well-being.\n"+
                "\n" +
                "Ultimately, BalancedBite is about finding harmony in your eating habits and embracing a balanced approach to nourishing your body. By prioritizing balance, moderation, and variety in your diet, you can support your overall health and well-being while still enjoying the foods you love.\n" +
                "\n"+
                "\n"
    }
}