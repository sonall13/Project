package com.example.serene.GetData

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R

class JournalingDataActivity : AppCompatActivity() {

    lateinit var date : TextView
    lateinit var selectcattext : TextView
    private lateinit var back : ImageButton
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
        date = findViewById(R.id.date)
        back = findViewById(R.id.back)
        selectcattext = findViewById(R.id.selectcattext)

        back.setOnClickListener {
          startActivity(Intent(this,VerticalCalendar::class.java))
            finish()
        }

        date.text=intent.getStringExtra("formattedDate")
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
                0 -> {selectcattext.visibility =View.INVISIBLE
                    MorningFragment()}
                1 ->  {selectcattext.visibility =View.INVISIBLE
                    NightFragment()}

                2 ->  {selectcattext.visibility =View.INVISIBLE
                    GratitudeFragment()}

                3 ->  {selectcattext.visibility =View.INVISIBLE
                    FreestyleFragment()}

                4 ->  {selectcattext.visibility =View.INVISIBLE
                    MemoriesFragment()}

                else -> {selectcattext.visibility =View.INVISIBLE
                    MorningFragment()}
            }

            fragment.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.cat_frame, it as Fragment)
                    .commit()
            }
        }
        sliderRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        sliderRecyclerView.adapter = adapter
    }

}
