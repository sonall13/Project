package com.example.serene.HealthyEatingActivity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.serene.R

class HealthfulHaven : AppCompatActivity() {
    lateinit var  articaltext : TextView

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
        setContentView(R.layout.activity_healthful_haven)

        articaltext =findViewById(R.id.articaltext)

        articaltext.text = "5. HealthfulHaven: Creating a Nurturing Environment for Healthy Eating\n" +
                "\n" +
                "HealthfulHaven is more than just a way of eating—it's a lifestyle that encompasses creating a supportive environment for healthy eating habits to thrive. From stocking your kitchen with nutritious foods to planning and preparing meals ahead of time, HealthfulHaven is all about setting yourself up for success on your health journey.\n" +
                "\n" +
                "One of the key principles of HealthfulHaven is to create a kitchen environment that supports your health goals. This means stocking your pantry, refrigerator, and freezer with wholesome, nutrient-rich foods such as fruits, vegetables, whole grains, lean proteins, and healthy fats. By having these ingredients readily available, you can make healthier choices and avoid reaching for unhealthy snacks when hunger strikes.\n" +
                "\n" +
                "Meal planning is another essential aspect of the HealthfulHaven lifestyle. Taking the time to plan your meals for the week ahead ensures that you have nutritious options available and reduces the likelihood of turning to fast food or takeout on busy days. Consider creating a weekly meal plan and grocery list to streamline your shopping and meal preparation process."+
        "\n" +
                ". HealthfulHaven:\n" +
                "\n" +
                "Cultivate a supportive environment for healthy eating by stocking your kitchen with nutritious staples such as fruits, vegetables, whole grains, lean proteins, and healthy fats. Having these ingredients readily available makes it easier to prepare wholesome meals at home.\n" +
                "\n" +
                "Plan your meals ahead of time to ensure you have nutritious options available throughout the week. Consider creating a weekly meal plan and grocery list to streamline your shopping and meal preparation process.\n" +
                "\n" +
                "Prioritize homemade meals over dining out or ordering takeout, as this gives you more control over the ingredients and cooking methods used. Experiment with new recipes and cooking techniques to keep meals interesting and flavorful.\n" +
                "\n" +
                "Prepare meals in batches and portion them out for convenient grab-and-go options during busy days. Investing in reusable containers and meal prep tools can help streamline the process and make meal prep more enjoyable.\n" +
                "\n" +
                "Get creative with meal ideas by incorporating a variety of flavors, textures, and cuisines into your cooking. Don't be afraid to experiment with different ingredients and cooking methods to keep meals exciting and satisfying.\n" +
                "\n" +
                "Embrace the concept of \"eating the rainbow\" by including a colorful variety of fruits and vegetables in your meals. Different colors often indicate different nutrients, so aim for a diverse selection to maximize your nutrient intake.\n" +
                "\n" +
                "Focus on whole, minimally processed foods that are rich in nutrients and free from artificial additives and preservatives. Read food labels carefully and choose products with simple, recognizable ingredients.\n" +
                "\n" +
                "Practice mindful eating by paying attention to your body's hunger and fullness cues, as well as the taste, texture, and enjoyment of your food. Avoid distractions while eating and savor each bite to enhance the eating experience.\n" +
                "\n" +
                "Stay hydrated by drinking plenty of water throughout the day. Carry a reusable water bottle with you and sip water regularly, especially during and after exercise or when you're feeling thirsty.\n" +
                "\n" +
                "Be kind to yourself and allow for flexibility in your eating habits. Focus on progress over perfection and celebrate your successes, no matter how small. Remember that healthy eating is about nourishing your body and soul with nutritious foods that make you feel your best."+
        "\n" +
                "HealthfulHaven: TIPS\n" +
                "\n" +
                "Create a supportive environment for healthy eating by stocking your kitchen with nutritious foods and minimizing temptations for unhealthy snacks.\n" +
                "\n" +
                "Plan and prepare meals ahead of time to make healthier choices more convenient, especially during busy days.\n" +
                "\n" +
                "Seek out healthy recipes and cooking inspiration to keep your meals interesting and enjoyable."+
        "\n" +
                "In addition to meal planning, HealthfulHaven also emphasizes the importance of meal preparation. Taking the time to prepare meals ahead of time can save you time and energy during the week and make it easier to stick to your health goals. Consider batch cooking on the weekends and portioning out meals for easy grab-and-go options throughout the week.\n" +
                "\n" +
                "Creating a supportive environment for healthy eating also means surrounding yourself with positive influences and support systems. Whether it's joining a cooking class, finding a workout buddy, or seeking out online communities that share your health goals, surrounding yourself with like-minded individuals can help keep you motivated and accountable on your health journey.\n" +
                "\n" +
                "Ultimately, HealthfulHaven is about creating a nurturing environment that supports your health and well-being. By stocking your kitchen with nutritious foods, planning and preparing meals ahead of time, and surrounding yourself with positive influences, you can set yourself up for success on your health journey and create a life filled with health and vitality."


    }
}