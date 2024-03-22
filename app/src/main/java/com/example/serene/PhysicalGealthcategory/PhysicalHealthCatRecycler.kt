package com.example.serene.PhysicalGealthcategory

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.Adapters.Breathingadpter
import com.example.serene.MentalHealthCategorys.Anxietyadp
import com.example.serene.MentalHealthCategorys.Meditationadp
import com.example.serene.R

class PhysicalHealthCatRecycler : AppCompatActivity() {

    lateinit var recycler :RecyclerView

    var stretching = ArrayList<String>()
    var strdrw = ArrayList<String>()
    var healthyEating = ArrayList<String>()
    var yoga = ArrayList<String>()
    var ActiveAura = ArrayList<String>()
    var VitalVibe = ArrayList<String>()
    var StaminaSculpt = ArrayList<String>()

    var drawablearray = ArrayList<Int>()

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
        setContentView(R.layout.activity_physical_health_cat_recycler)


        recycler =findViewById(R.id.recycler)
        var data = intent.getIntExtra("data",0)


        drawablearray.add(R.drawable.y1)
        drawablearray.add(R.drawable.y2)
        drawablearray.add(R.drawable.y3)
        drawablearray.add(R.drawable.y4)
        drawablearray.add(R.drawable.y5)
        drawablearray.add(R.drawable.yogga3)
        drawablearray.add(R.drawable.y6)
        drawablearray.add(R.drawable.staggered2)
        drawablearray.add(R.drawable.staggered4)
        drawablearray.add(R.drawable.staggered6)
//        strdrw.add(R.drawable.stretching)


        stretching.add("FlexFlow")
        stretching.add("StretchSync")
        stretching.add("FlexEase")
        stretching.add("StretchRevive")
        stretching.add("FlexibilityFocus")


        healthyEating.add("WholesomeWell")
        healthyEating.add("CleanEats Corner")
        healthyEating.add("Vibrant Veggies")
        healthyEating.add("NutriNova")
        healthyEating.add("HealthfulHaven")
        healthyEating.add("CleanCuisine")
        healthyEating.add("BalancedBite")

        yoga.add("yogazen")
        yoga.add("YogaVibe")
        yoga.add("NamasteNest")
        yoga.add("SereneAsanas")
        yoga.add("Yogicjourney")
        yoga.add("YogaEssence")
        yoga.add("OmOasis")
        yoga.add("SuryaNamskar")
        yoga.add("AnlomVilom")


        ActiveAura.add("DynamicGlow")
        ActiveAura.add("AuraActivator")
        ActiveAura.add("AuraAscend")
        ActiveAura.add("SparkSphere")
        ActiveAura.add("EnergeticEden")


        VitalVibe.add("RadiantRhythms")
        VitalVibe.add("VibrantVista")
        VitalVibe.add("VitalSpark")
        VitalVibe.add("VitalFlow")
        VitalVibe.add("Energize")
        VitalVibe.add("VitalityVortex")


        StaminaSculpt.add("CoreCharge")
        StaminaSculpt.add("SculptSquad")
        StaminaSculpt.add("SculptStrong")
        StaminaSculpt.add("VigorVista")
        StaminaSculpt.add("SculptifyStrenght")


        when(data){

            0 ->{
                var stretchingadp = Stretchingadp(this,stretching,drawablearray)
                recycler.adapter = stretchingadp
            }
            1 ->{
                var healthyEatingadp = HealthyEatingadp(this,healthyEating,drawablearray)
                recycler.adapter = healthyEatingadp
            }
            2 ->{
                var yoga_adp = Yoga_adp(this,yoga,drawablearray)
                recycler.adapter = yoga_adp
            }
            3 ->{
                var ActiveAuraadp = ActiveAuraadp(this,ActiveAura,drawablearray)
                recycler.adapter = ActiveAuraadp
            }
            4 ->{
                var VitalVibeadp = VitalVibeadp(this,VitalVibe,drawablearray)
                recycler.adapter = VitalVibeadp
            }
            5 ->{
                var StaminaSculptadp = StaminaSculptadp(this,StaminaSculpt,drawablearray)
                recycler.adapter = StaminaSculptadp
            }

        }


    }
}