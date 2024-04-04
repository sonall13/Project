package com.example.serene

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.Bottumnavigation.Home
import com.example.serene.Bottumnavigation.JournalingFregment
import com.example.serene.Bottumnavigation.ProfileFregment
import com.example.serene.Bottumnavigation.ProgressFregment
import com.example.serene.Bottumnavigation.SleepTrekarFregment
import com.example.serene.Drawernav.Mental_health
import com.example.serene.Drawernav.Physical_health
import com.example.serene.GetData.JournalingDataActivity
import com.example.serene.GetData.VerticalCalendar
import com.example.serene.JournalingActivity.JournalingCreateDataClass
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home_page : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    lateinit var drawer: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var data1: ImageView
    lateinit var bottom_navigation: BottomNavigationView
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
        setContentView(R.layout.activity_home_page)

        loadFragment(Home())
        drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        bottom_navigation = findViewById(R.id.bottom_navigation)
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        data1 = findViewById(R.id.data)

        data1.setOnClickListener {

            startActivity(Intent(this,VerticalCalendar::class.java))
        }

        setSupportActionBar(toolbar)

        bottom_navigation = findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottom_navigation.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.home -> {
                    loadFragment(Home())
                    toolbar.title = "Serene"
                    true
                }

//                R.id.progress -> {
//                    loadFragment(ProgressFregment())
//                    true
//                }

                R.id.profile -> {
                    loadFragment(ProfileFregment())
                    toolbar.title = "Serene"
                    true
                }

                R.id.journaling -> {
                    loadFragment(JournalingFregment())
                    toolbar.title = "Serene"
                    true
                }

                R.id.sleep_traker -> {
                    loadFragment(SleepTrekarFregment())
                    toolbar.title = "Serene"
                    true
                }

                else -> {
                    loadFragment(Home())
                    true

                }
            }
        }
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.open_drawer,
            R.string.close_drawer
        )

        drawer.addDrawerListener(toggle)
        toggle.syncState()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Home()).commit()
            navigationView.setCheckedItem(R.id.home)
            bottom_navigation.selectedItemId = R.id.home
        }
    }

    private fun loadFragment(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()

    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.mental_health -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Mental_health()).commit()
                toolbar.title = "Mental Health"

            }

            R.id.physical_health -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Physical_health()).commit()
                toolbar.title = "Physical Health"
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        super.onBackPressed()
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}