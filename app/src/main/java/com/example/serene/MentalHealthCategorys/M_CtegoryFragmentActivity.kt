package com.example.serene.MentalHealthCategorys

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.Adapters.Breathingadpter
import com.example.serene.R
import kotlin.collections.ArrayList

class M_CtegoryFragmentActivity : AppCompatActivity() {

    lateinit var fragmentrecycler : RecyclerView


    var BreathingArray = ArrayList<String>()
    var Meditation = ArrayList<String>()
    var Anxiety = ArrayList<String>()
    var Affirmation = ArrayList<String>()
    var SelfCare = ArrayList<String>()
    var StressReduce = ArrayList<String>()

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
        setContentView(R.layout.activity_mctegory_fragment)

        fragmentrecycler =findViewById(R.id.fragmentrecycler)

        drawablearray.add(R.drawable.staggered6)
        drawablearray.add(R.drawable.staggered7)
        drawablearray.add(R.drawable.staggered2)
        drawablearray.add(R.drawable.staggered4)
        drawablearray.add(R.drawable.staggered7)
        drawablearray.add(R.drawable.staggered4)
        drawablearray.add(R.drawable.staggered6)
        drawablearray.add(R.drawable.staggered2)
        drawablearray.add(R.drawable.staggered4)
        drawablearray.add(R.drawable.staggered6)


        var breathing = intent.getIntExtra("breathing",0)

        //BreathingArray
            BreathingArray.add("deep diaphragm")
            BreathingArray.add("aum chant")
            BreathingArray.add("de-stress")
            BreathingArray.add("focus")
            BreathingArray.add("Wakeup")
            BreathingArray.add("Serene pulse")
            BreathingArray.add("SootheSphere")
            BreathingArray.add("ZenBreath")
            BreathingArray.add("Calmcycles")


        //Meditation
        Meditation.add("Mindfulness")
        Meditation.add("Spiritual")
        Meditation.add("Focused")
        Meditation.add("Mantra")
        Meditation.add("Kindness")
        Meditation.add("Chakra")
        Meditation.add("Concentrate")
        Meditation.add("SereneSoul")
        Meditation.add("serenitySphere")
        Meditation.add("SereneSoulSpace")

        //Anxiety
        Anxiety.add("SereneSupport")
        Anxiety.add("InnerCalmness")
        Anxiety.add("Harmonyheal")
        Anxiety.add("Calmcare")
        Anxiety.add("RelaxationRefuge")
        Anxiety.add("ComfortCove")
        Anxiety.add("CalmWave")
        Anxiety.add("EaseAnx")

        //Affirmation
        Affirmation.add("GlowUpGrove")
        Affirmation.add("DreamDestiny")
        Affirmation.add("ResilienceRise")
        Affirmation.add("AffirmArcade")
        Affirmation.add("InspireInfinity")
        Affirmation.add("ZenAffirm")
        Affirmation.add("AffirmativeAura")
        Affirmation.add("EncourageU")

        //SelfCare
        SelfCare.add("ChillOutCove")
        SelfCare.add("SereneSolutions")
        SelfCare.add("StressBusterHub")
        SelfCare.add("RelaxationRealm")
        SelfCare.add("StressEase")
        SelfCare.add("SereneSanctuary")
        SelfCare.add("StressFreeZone")
        SelfCare.add("PeacefulPause")

        //StressReduce
        StressReduce.add("SerenitySelf")
        StressReduce.add("SelfCareSage")
        StressReduce.add("EmpowermentEden")
        StressReduce.add("CalmCoCoon")
        StressReduce.add("TranquiTouches")
        StressReduce.add("BlissfulBreak")

        when(breathing){

            0 ->{
                var breathingArrayadp = Breathingadpter(this,BreathingArray,drawablearray)
                fragmentrecycler.adapter = breathingArrayadp
            }
            1 ->{
                var meditationadp = Meditationadp(this,Meditation,drawablearray)
                fragmentrecycler.adapter = meditationadp
            }
            2->{
                var anxietyadp = Anxietyadp(this,Anxiety,drawablearray)
                fragmentrecycler.adapter = anxietyadp
            }
            3 ->{
                var affirmationadp = Affirmationadp(this,Affirmation,drawablearray)
                fragmentrecycler.adapter = affirmationadp
            }
            4 ->{
                var selfCareadp = SelfCareadp(this,SelfCare,drawablearray)
                fragmentrecycler.adapter = selfCareadp
            }
            5 ->{
                var stressReduceadp = StressReduceadp(this,StressReduce,drawablearray)
                fragmentrecycler.adapter = stressReduceadp
            }


        }



    }
}