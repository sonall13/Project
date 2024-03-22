package com.example.serene.HealthyEatingActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.serene.R

class VibrantVeggies : AppCompatActivity() {
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
        setContentView(R.layout.activity_vibrant_veggies)

        articaltext =findViewById(R.id.articaltext)
        subtext =findViewById(R.id.subtextt)
        subtext2 =findViewById(R.id.subtext2)
        subtext3 =findViewById(R.id.subtext3)
        subtext4 =findViewById(R.id.subtext4)
        back =findViewById(R.id.back)

        back.setOnClickListener {
            onBackPressed()
        }
        articaltext.text = " Vibrant Veggies: Celebrating the Health Benefits of Colorful Produce\n"

         subtext.text=    "When it comes to nourishing our bodies and supporting our health, few foods are as powerful as vibrant, colorful vegetables. From leafy greens and bright bell peppers to earthy root vegetables and sweet, juicy tomatoes, vegetables offer a wide range of nutrients and health benefits that can support our overall well-being.\n" +
                "\n" +
                "One of the key principles of Vibrant Veggies eating is to prioritize a rainbow of colors on our plates. Different colors in fruits and vegetables often indicate different nutrients and antioxidants, so by including a variety of colorful produce in our diets, we can ensure that we're getting a diverse range of nutrients to support our health.\n" +
                "\n" +
                "Leafy greens, such as spinach, kale, and Swiss chard, are particularly nutrient-dense and offer a host of health benefits. These greens are rich in vitamins A, C, and K, as well as minerals like iron, calcium, and magnesium, making them a valuable addition to any diet."
            subtext2.text=  ". Vibrant Veggies: Tips \n" +
                "\n" +
                "Incorporate a rainbow of colorful vegetables into your meals to maximize the variety of nutrients you consume. Different colors often indicate different nutrients and antioxidants, so aim for a diverse selection.\n" +
                "\n" +
                "Prioritize seasonal and locally grown vegetables whenever possible to ensure freshness and optimal flavor. Farmers' markets and community-supported agriculture (CSA) programs are great places to find locally sourced produce.\n" +
                "\n" +
                "Experiment with different cooking methods to enhance the flavor and texture of your vegetables. Try roasting, grilling, steaming, sautéing, or enjoying them raw in salads and slaws.\n" +
                "\n" +
                "Include leafy greens like spinach, kale, Swiss chard, and arugula in your diet regularly. These greens are packed with vitamins, minerals, and phytonutrients that support overall health.\n" +
                "\n" +
                "Add vegetables to every meal, including breakfast. Consider incorporating vegetables into omelets, smoothies, breakfast hashes, or avocado toast for a nutritious start to your day.\n"

              subtext3.text= " 1. Get creative with vegetable-based dishes by using them as substitutes for traditional grains or pasta. Spiralized vegetables, cauliflower rice, and zucchini noodles are great alternatives to refined carbohydrates.\n" +
                "\n" +
                " 2. Aim to fill half of your plate with vegetables at each meal to ensure you're getting plenty of fiber, vitamins, and minerals. This can help you feel satisfied while also reducing the calorie density of your meals.\n" +
                "\n" +
                " 3. Include a variety of cooking greens such as collard greens, mustard greens, and turnip greens in your diet. These nutrient-packed greens are rich in vitamins A, C, and K, as well as calcium and iron.\n" +
                "\n" +
                " 4. Prepare vegetable-based snacks to have on hand for quick and convenient munching. Cut-up raw vegetables with hummus, roasted chickpeas, and vegetable-based dips are healthy options for snacking.\n" +
                "\n" +
                " 5. Don't forget about frozen vegetables, which can be just as nutritious as fresh and are convenient to have on hand for quick meals. Stock your freezer with a variety of frozen vegetables to ensure you always have options available."+
        "\n" +

                " 6. Root vegetables, such as carrots, sweet potatoes, and beets, are another excellent source of nutrients and offer a variety of health benefits. These vegetables are rich in fiber, vitamins, and antioxidants, which can support digestive health, reduce inflammation, and boost immune function.\n" +
                "\n" +
                " 7. In addition to their nutritional benefits, Vibrant Veggies are also incredibly versatile and can be enjoyed in a variety of ways. From raw salads and smoothies to roasted vegetables and stir-fries, there are countless ways to incorporate colorful produce into your meals and snacks.\n" +
                "\n" +
                "Ultimately, embracing a diet rich in Vibrant Veggies is about celebrating the health benefits of colorful produce and prioritizing a wide range of nutrients to support our overall health and well-being. By including plenty of colorful fruits and vegetables in our diets, we can nourish our bodies with the essential nutrients they need to thrive and live our best lives." +
                "\n"

    }
}