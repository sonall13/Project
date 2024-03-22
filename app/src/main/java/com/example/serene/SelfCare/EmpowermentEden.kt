package com.example.serene.SelfCare

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.serene.R

class EmpowermentEden : AppCompatActivity() {
    lateinit var  selfcareartical : TextView
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
        setContentView(R.layout.activity_empowerment_eden)

        selfcareartical =findViewById(R.id.selfcareartical)
        back =findViewById(R.id.back)

        back.setOnClickListener {
            onBackPressed()
        }

        selfcareartical.text = " SereneSolution: Zen and the Art of Self-Care\n" +
                "\n" +
                "In the fast-paced world we live in, it's easy to get caught up in the chaos and forget to take care of ourselves. That's where SereneSolution comes in—a holistic approach to self-care that emphasizes the importance of nurturing our physical, emotional, and spiritual well-being.\n" +
                "\n" +
                "At the heart of SereneSolution is the belief that self-care is not selfish, but rather essential for our overall health and happiness. By taking time to prioritize our own needs, we can recharge our batteries and show up as our best selves in all areas of our lives.\n" +
                "\n" +
                "But what exactly does self-care look like? For some, it might involve practicing mindfulness meditation to quiet the mind and reduce stress. For others, it could mean indulging in a soothing bubble bath, taking a leisurely nature walk, or simply spending quality time with loved ones.\n" +
                "\n" +
                "Regardless of the form it takes, self-care is about tuning into our own needs and giving ourselves the love and attention we deserve. It's about recognizing that we are worthy of care and compassion, and taking proactive steps to nurture our own well-being.\n" +
                "\n" +
                "So how can you incorporate SereneSolution into your own life? Start by carving out time each day for self-care—whether it's a few minutes of meditation in the morning, a midday walk to clear your head, or an evening ritual to unwind before bed.\n" +
                "\n" +
                "Next, identify activities that bring you joy and make you feel good—from practicing yoga to cooking a delicious meal to indulging in a hobby you love. By incorporating these activities into your daily routine, you can cultivate a sense of serenity and balance that will help you navigate life's ups and downs with grace and ease.\n" +
                "\n" +
                "In conclusion, SereneSolution is more than just a set of practices—it's a way of life. By embracing the principles of self-care and prioritizing our own well-being, we can create a life that is filled with peace, joy, and fulfillment.\n" +
                "\n"

    }
}