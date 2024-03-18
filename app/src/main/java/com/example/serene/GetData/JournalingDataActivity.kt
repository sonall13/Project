package com.example.serene.GetData

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R

class JournalingDataActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_journaling_data)
        val selectedDate = intent.getStringExtra("selectedDate")

        val cat_frame = findViewById<FrameLayout>(R.id.cat_frame)
        val sliderRecyclerView = findViewById<RecyclerView>(R.id.sliderRecyclerView)

//
//        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        sliderRecyclerView.layoutManager = layoutManager
//        val categories = listOf("Morning", "Night", "Gratitude","Freestyle", "Memories") // Replace with your category data
//        val adapter = CategoryAdapter(categories)
//        sliderRecyclerView.adapter = adapter

        val categories = listOf("Morning", "Night", "Gratitude","Freestyle", "Memories") // Sample categories
        val adapter = CategoryAdapter(categories) { position ->
            val fragment = when (position) {
                0 -> MorningFragment()
                1 -> NightFragment()
                2 -> GratitudeFragment()
//                3 -> FreestyleFragment()
//                4 -> MemoriesFragment()

                else -> MorningFragment()
            }

            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.cat_frame, it)
                    .commit()
            }
        }
        sliderRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        sliderRecyclerView.adapter = adapter
    }
}
