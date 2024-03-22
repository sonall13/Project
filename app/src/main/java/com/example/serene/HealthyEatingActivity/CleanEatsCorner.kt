package com.example.serene.HealthyEatingActivity

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.serene.R

class CleanEatsCorner : AppCompatActivity() {
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
        setContentView(R.layout.activity_clean_eats_corner)

        articaltext =findViewById(R.id.articaltext)

  articaltext.text = "CleanEats Corner: Embracing Clean Eating for Optimal Health\n" +
          "\n" +
          "In a world filled with processed foods and artificial additives, many people are turning to clean eating as a way to prioritize their health and well-being. CleanEats Corner is all about embracing a clean eating lifestyle that focuses on consuming whole, minimally processed foods that are as close to their natural state as possible.\n" +
          "\n" +
          "At the heart of the CleanEats Corner philosophy is the belief that food should be nourishing and free from artificial additives, preservatives, and chemicals. By choosing foods that are clean and minimally processed, we can fuel our bodies with the nutrients they need to thrive while minimizing our exposure to potentially harmful ingredients.\n" +
          "\n" +
          "CleanEats Corner: tips\n" +
          "\n" +
          "Choose clean, unprocessed foods that are free from additives, preservatives, and artificial ingredients.\n" +
          "Read food labels and opt for products with simple, recognizable ingredients.\n" +
          "\n" +
          "Cook meals at home using fresh, whole ingredients to have better control over the quality of your food."+
        "\n" +
          "One of the key principles of clean eating is to focus on whole foods that are rich in nutrients and free from added sugars, unhealthy fats, and excessive salt. This means filling our plates with plenty of fruits and vegetables, whole grains, lean proteins, and healthy fats, while avoiding highly processed foods and sugary snacks.\n" +
          "\n" +
          "In addition to prioritizing whole, nutrient-rich foods, CleanEats Corner also emphasizes the importance of mindful eating. This means paying attention to our hunger and fullness cues, as well as the taste, texture, and enjoyment of our food. By slowing down and savoring each bite, we can better appreciate the flavors and nourishment that whole foods provide.\n" +
          "\n" +
          "Another key aspect of clean eating is cooking meals at home using fresh, whole ingredients. By preparing our own meals, we can have more control over the ingredients and cooking methods used, allowing us to make healthier choices and avoid hidden sources of unhealthy additives.\n" +
          "\n" +
          "2. CleanEats Corner:\n" +
          "\n" +
          "Prioritize clean, whole foods that are minimally processed and free from artificial additives, preservatives, and chemicals. Choose foods with simple, recognizable ingredients to support optimal health.\n" +
          "\n" +
          "Read food labels carefully and avoid products with long lists of artificial ingredients, added sugars, and unhealthy fats. Opt for products with minimal ingredients and no artificial additives whenever possible.\n" +
          "\n" +
          "Cook meals from scratch using fresh, whole ingredients. Homemade meals allow you to control the quality of the ingredients and avoid hidden sources of unhealthy additives.\n" +
          "\n" +
          "Choose organic produce when feasible to minimize exposure to pesticides and other chemicals. Prioritize organic options for fruits and vegetables that are known to have higher pesticide residues.\n" +
          "\n" +
          "Limit your intake of processed foods such as sugary snacks, fast food, and packaged convenience foods. These foods are often high in unhealthy fats, added sugars, and sodium, which can contribute to poor health.\n" +
          "\n" +
          "Stock your pantry with clean eating essentials such as whole grains, legumes, nuts, seeds, herbs, and spices. Having a well-stocked pantry makes it easier to prepare nutritious meals at home.\n" +
          "\n" +
          "Experiment with new recipes and cooking techniques to keep meals interesting and flavorful. Explore different cuisines and cooking methods to discover new favorite dishes.\n" +
          "\n" +
          "Be mindful of portion sizes and avoid overeating, even with clean, healthy foods. Practice moderation and listen to your body's hunger and fullness cues to maintain a balanced approach to eating.\n" +
          "\n" +
          "Choose sustainable and ethically sourced foods whenever possible to support environmental and social responsibility. Look for certifications such as Fair Trade and Rainforest Alliance to ensure ethical production practices.\n" +
          "\n" +
          "Focus on the quality of your food choices rather than strict dietary rules or restrictions. Embrace a flexible approach to eating that prioritizes whole, clean foods while allowing for occasional indulgences.\n" +
          "\n"
          "\n" +
          "Ultimately, adopting a clean eating lifestyle is about nourishing our bodies with wholesome, nutrient-rich foods while minimizing our exposure to artificial additives and processed ingredients. By embracing the principles of clean eating and prioritizing whole, minimally processed foods, we can fuel our bodies with the nutrients they need to thrive and support our overall health and well-being.\n" +
          "\n"

    }
}