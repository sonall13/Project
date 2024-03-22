package com.example.serene.HealthyEatingActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.serene.R

class NutriNova : AppCompatActivity() {

    lateinit var  articaltext :TextView


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

        articaltext =findViewById(R.id.articaltext)

        articaltext.text = " NutriNova: Elevating Your Nutrition with Nutrient-Dense Foods\n" +
                "\n" +
                "NutriNova is all about taking your nutrition to the next level by incorporating nutrient-dense foods into your diet. These foods are packed with essential vitamins, minerals, antioxidants, and other nutrients that support optimal health and well-being.\n" +
                "\n" +
                "One of the key principles of NutriNova eating is to focus on foods that provide a high concentration of nutrients relative to their calorie content. This means choosing foods that offer the most bang for your buck in terms of nutritional value. Examples of nutrient-dense foods include fruits, vegetables, lean proteins, whole grains, nuts, seeds, and legumes.\n" +
                "\n" +
                "In addition to prioritizing nutrient-dense foods, NutriNova also emphasizes the importance of variety in your diet. Eating a wide range of nutrient-rich foods ensures that you're getting all the essential vitamins, minerals, and other nutrients your body needs to function optimally.\n" +
                "\n"+
        ". NutriNova:TIPS\n" +
                "\n" +
                "Choose nutrient-dense foods that provide a high concentration of essential nutrients per calorie. Focus on foods that are rich in vitamins, minerals, protein, fiber, and healthy fats to support overall health.\n" +
                "\n" +
                "Prioritize whole foods over processed foods, as they tend to be higher in nutrients and lower in unhealthy additives. Fill your plate with a variety of colorful fruits, vegetables, whole grains, lean proteins, and healthy fats.\n" +
                "\n" +
                "Opt for foods that are rich in antioxidants, which help protect your cells from damage caused by free radicals. Include colorful fruits and vegetables, nuts, seeds, and herbs and spices in your diet to boost your antioxidant intake.\n" +
                "\n" +
                "Include sources of omega-3 fatty acids in your diet, such as fatty fish (salmon, sardines, mackerel), flaxseeds, chia seeds, walnuts, and hemp seeds. Omega-3s are essential for heart health, brain function, and reducing inflammation.\n" +
                "\n" +
                "Eat a variety of protein sources to ensure you're getting all essential amino acids. Incorporate lean proteins such as poultry, fish, tofu, tempeh, legumes, nuts, and seeds into your meals.\n" +
                "\n" +
                "Consume foods rich in calcium to support bone health and muscle function. Include dairy products, fortified plant-based milks, leafy greens, tofu, almonds, and sesame seeds in your diet to meet your calcium needs.\n" +
                "\n" +
                "Don't forget about fiber, which is essential for digestive health and can help lower cholesterol levels and regulate blood sugar. Aim to include plenty of fiber-rich foods like fruits, vegetables, whole grains, legumes, nuts, and seeds in your diet.\n" +
                "\n" +
                "Be mindful of your vitamin D intake, especially if you have limited sun exposure. Consider incorporating vitamin D-rich foods such as fatty fish, fortified dairy products, fortified plant-based milks, egg yolks, and mushrooms into your diet.\n" +
                "\n" +
                "Stay hydrated by drinking plenty of water throughout the day. Water is essential for digestion, nutrient absorption, temperature regulation, and overall well-being.\n" +
                "\n" +
                "Seek out whole, minimally processed foods that are rich in vitamins, minerals, and other essential nutrients to support your overall health and well-being. Focus on nourishing your body with nutrient-dense foods that provide lasting energy and promote optimal health.\n" +
                "\n" +
                "NutriNova:TIPS\n" +
                "\n" +
                "Focus on nutrient-dense foods that provide a high concentration of essential nutrients relative to their calorie content.\n" +
                "\n" +
                "Choose foods rich in vitamins, minerals, protein, fiber, and healthy fats to support overall health and well-being.\n" +
                "\n" +
                "Opt for whole foods over processed foods to maximize your nutrient intake and promote optimal nutrition."+
        "\n" +
                "Another key aspect of NutriNova eating is to pay attention to the quality of your food choices. This means opting for whole, minimally processed foods whenever possible and avoiding foods that are high in added sugars, unhealthy fats, and artificial additives.\n" +
                "\n" +
                "Incorporating nutrient-dense foods into your diet can have numerous health benefits, including improved energy levels, enhanced immune function, better digestion, and reduced risk of chronic disease. By prioritizing foods that nourish your body from the inside out, you can support your overall health and well-being and feel your best every day.\n" +
                "\n" +
                "Ultimately, NutriNova is about elevating your nutrition and taking a proactive approach to your health by fueling your body with the nutrients it needs to thrive. By incorporating nutrient-dense foods into your diet and prioritizing quality and variety in your food choices, you can optimize your nutrition and support your long-term health and vitality."+
        "\n"
    }
}