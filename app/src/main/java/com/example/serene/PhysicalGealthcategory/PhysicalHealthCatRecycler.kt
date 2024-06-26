package com.example.serene.PhysicalGealthcategory

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R

class PhysicalHealthCatRecycler : AppCompatActivity() {

    lateinit var recycler :RecyclerView
    lateinit var  back : ImageButton
    lateinit var  tittlename : TextView

    var stretching = ArrayList<String>()
    var strdrw = ArrayList<Int>()
    var healthyEating = ArrayList<String>()
    var yoga = ArrayList<String>()
    var drawablearray = ArrayList<Int>()
    var ActiveAura = ArrayList<String>()
    var Auradraw = ArrayList<Int>()
    var VitalVibe = ArrayList<String>()
    var vitaldraw = ArrayList<Int>()
    var StaminaSculpt = ArrayList<String>()
    var staminadraw = ArrayList<Int>()
    var yogadraw = ArrayList<Int>()

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

        back =findViewById(R.id.back)
        tittlename =findViewById(R.id.tittlename)
        back.setOnClickListener {
            onBackPressed()
        }

        recycler =findViewById(R.id.recycler)
        var data = intent.getIntExtra("data",0)

        when(data){
            0 -> tittlename.text = "Stretching"
            1 -> tittlename.text = "Healthy Eating"
            2 -> tittlename.text = "Yoga"
            3 -> tittlename.text = "Vital Vibe"
            4 -> tittlename.text = "Stamina Sculpt"
            5 -> tittlename.text = "Active Aura"
        }

        stretching.add("FlexFlow")
        stretching.add("StretchSync")
        stretching.add("FlexEase")
        stretching.add("StretchRevive")
        stretching.add("FlexibilityFocus")
        strdrw.add(R.drawable.str1)
        strdrw.add(R.drawable.str2)
        strdrw.add(R.drawable.str3)
        strdrw.add(R.drawable.str4)
        strdrw.add(R.drawable.str5)


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
        yoga.add("katichakrasana")
        yogadraw.add(R.drawable.yogazen)
        yogadraw.add(R.drawable.yogavibe)
        yogadraw.add(R.drawable.namstenest)
        yogadraw.add(R.drawable.sereneasanas)
        yogadraw.add(R.drawable.yogicjourny)
        yogadraw.add(R.drawable.yogaesswnce)
        yogadraw.add(R.drawable.omoasis)
        yogadraw.add(R.drawable.janu_sirsasana)
        yogadraw.add(R.drawable.katichakrasana)



        drawablearray.add(R.drawable.ss1)
        drawablearray.add(R.drawable.ss2)
        drawablearray.add(R.drawable.ss3)
        drawablearray.add(R.drawable.ss4)
        drawablearray.add(R.drawable.sss8)
        drawablearray.add(R.drawable.sss7)
        drawablearray.add(R.drawable.ss7)


        ActiveAura.add("DynamicGlow")
        ActiveAura.add("AuraActivator")
        ActiveAura.add("AuraAscend")
        ActiveAura.add("SparkSphere")
        ActiveAura.add("EnergeticEden")

        Auradraw.add(R.drawable.dy)
        Auradraw.add(R.drawable.auractivator)
        Auradraw.add(R.drawable.auraascend)
        Auradraw.add(R.drawable.sparksphere)
        Auradraw.add(R.drawable.energeticeden)


        VitalVibe.add("RadiantRhythms")
        VitalVibe.add("VibrantVista")
        VitalVibe.add("VitalSpark")
        VitalVibe.add("VitalFlow")
        VitalVibe.add("Energize")
        VitalVibe.add("VitalityVortex")

        vitaldraw.add(R.drawable.vitalvibe1)
        vitaldraw.add(R.drawable.vitalvibe2)
        vitaldraw.add(R.drawable.vitalvibe3)
        vitaldraw.add(R.drawable.vitalvibe4)
        vitaldraw.add(R.drawable.vitalvibe5)
        vitaldraw.add(R.drawable.stamina1)


        StaminaSculpt.add("CoreCharge")
        StaminaSculpt.add("SculptSquad")
        StaminaSculpt.add("SculptStrong")
        StaminaSculpt.add("VigorVista")
        StaminaSculpt.add("SculptifyStrenght")
        staminadraw.add(R.drawable.stamina1)
        staminadraw.add(R.drawable.stamina2)
        staminadraw.add(R.drawable.stamina3)
        staminadraw.add(R.drawable.stamina4)
        staminadraw.add(R.drawable.stamina5)

        when(data){

            0 ->{
                var stretchingadp = Stretchingadp(this,stretching,strdrw)
                recycler.adapter = stretchingadp
            }
            1 ->{
                var healthyEatingadp = HealthyEatingadp(this,healthyEating,drawablearray)
                recycler.adapter = healthyEatingadp
            }
            2 ->{
                var yoga_adp = Yoga_adp(this,yoga,yogadraw)
                recycler.adapter = yoga_adp
            }
            3 ->{
                var ActiveAuraadp = ActiveAuraadp(this,ActiveAura,Auradraw)
                recycler.adapter = ActiveAuraadp
            }
            4 ->{
                var VitalVibeadp = VitalVibeadp(this,VitalVibe,vitaldraw)
                recycler.adapter = VitalVibeadp
            }
            5 ->{
                var StaminaSculptadp = StaminaSculptadp(this,StaminaSculpt,staminadraw)
                recycler.adapter = StaminaSculptadp
            }

        }

    }
}