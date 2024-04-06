package com.example.serene.MentalHealthCategorys

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.Adapters.Breathingadpter
import com.example.serene.R
import com.example.serene.SliderData
import kotlin.collections.ArrayList

class M_CtegoryFragmentActivity : AppCompatActivity() {

    lateinit var fragmentrecycler : RecyclerView
    lateinit var  back : ImageButton
    lateinit var tittlename : TextView

    var BreathingArray = ArrayList<String>()
    var Meditation = ArrayList<String>()
    var Anxiety = ArrayList<String>()
    var Affirmation = ArrayList<String>()
    var SelfCare = ArrayList<String>()
    var StressReduce = ArrayList<String>()

    var bdraw = ArrayList<Int>()
    var mdraw = ArrayList<Int>()
    var adraw = ArrayList<Int>()
    var afdraw = ArrayList<Int>()
    var sdraw = ArrayList<Int>()
    var sedraw = ArrayList<Int>()



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
        tittlename =findViewById(R.id.tittlename)

        back =findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }
        var breathing = intent.getIntExtra("breathing",0)


        when(breathing){
            0 -> tittlename.text = "Breathing"
            1 -> tittlename.text = "Meditation"
            2 -> tittlename.text = "Anxiety"
            3 -> tittlename.text = "Affirmation"
            4 -> tittlename.text = "Selfcare"
            5 -> tittlename.text = "Stress Reduce"
        }


        bdraw.add(R.drawable.deepdiaphragm)
        bdraw.add(R.drawable.vv2)
        bdraw.add(R.drawable.vv1)
        bdraw.add(R.drawable.bb2)
        bdraw.add(R.drawable.v6)
        bdraw.add(R.drawable.v7)
        bdraw.add(R.drawable.v13)
        bdraw.add(R.drawable.v14)


        mdraw.add(R.drawable.md1)
        mdraw.add(R.drawable.md8)
        mdraw.add(R.drawable.md3)
        mdraw.add(R.drawable.md4)
        mdraw.add(R.drawable.md5)
        mdraw.add(R.drawable.md6)
        mdraw.add(R.drawable.md7)
        mdraw.add(R.drawable.md2)


        adraw.add(R.drawable.ad1)
        adraw.add(R.drawable.ad2)
        adraw.add(R.drawable.ad3)
        adraw.add(R.drawable.ad4)
        adraw.add(R.drawable.ad5)
        adraw.add(R.drawable.ad6)
        adraw.add(R.drawable.ad7)
        adraw.add(R.drawable.ad7)

        afdraw.add(R.drawable.afd1)
        afdraw.add(R.drawable.afd2)
        afdraw.add(R.drawable.afd4)
        afdraw.add(R.drawable.afd3)
        afdraw.add(R.drawable.afd5)
        afdraw.add(R.drawable.afd7)
        afdraw.add(R.drawable.afd6)


        sdraw.add(R.drawable.sr1)
        sdraw.add(R.drawable.sr2)
        sdraw.add(R.drawable.sr3)
        sdraw.add(R.drawable.sr7)
        sdraw.add(R.drawable.sr5)
        sdraw.add(R.drawable.sr6)

        sedraw.add(R.drawable.selfcare1)
        sedraw.add(R.drawable.selfcare5)
        sedraw.add(R.drawable.selfcare2)
        sedraw.add(R.drawable.selfcare3)
        sedraw.add(R.drawable.selfcare4)
        sedraw.add(R.drawable.selfcare6)
        sedraw.add(R.drawable.selfcare7)




        //BreathingArray
            BreathingArray.add("deep diaphragm")
            BreathingArray.add("aum chant")
            BreathingArray.add("de-stress")
            BreathingArray.add("focus")
            BreathingArray.add("Wakeup")
            BreathingArray.add("Serene pulse")
            BreathingArray.add("ZenBreath")
            BreathingArray.add("Calmcycles")

        //Meditation
        Meditation.add("Mindfulness")
        Meditation.add("Spiritual")
        Meditation.add("Focused")
        Meditation.add("Mantra")
        Meditation.add("Chakra")
        Meditation.add("Concentrate")
        Meditation.add("SereneSoul")
        Meditation.add("SereneSoulSpace")

        //Anxiety
        Anxiety.add("SereneSupport")
        Anxiety.add("InnerCalmness")
        Anxiety.add("Harmonyheal")
        Anxiety.add("Calmcare")
        Anxiety.add("RelaxationRefuge")
        Anxiety.add("CalmWave")
        Anxiety.add("EaseAnx")

        //Affirmation
        Affirmation.add("GlowUpGrove")
        Affirmation.add("DreamDestiny")
        Affirmation.add("ResilienceRise")
        Affirmation.add("AffirmArcade")
        Affirmation.add("InspireInfinity")
        Affirmation.add("ZenAffirm")
        Affirmation.add("EncourageU")

        //SelfCare
        SelfCare.add("ChillOutCove")
        SelfCare.add("SereneSolutions")
        SelfCare.add("StressBusterHub")
        SelfCare.add("RelaxationRealm")
        SelfCare.add("StressEase")



        //StressReduce
        StressReduce.add("SerenitySelf")
        StressReduce.add("SelfCareSage")
        StressReduce.add("EmpowermentEden")
        StressReduce.add("CalmCoCoon")
        StressReduce.add("TranquiTouches")
        StressReduce.add("BlissfulBreak")
//        SelfCare.add("SereneSanctuary")
//        SelfCare.add("StressFreeZone")

        when(breathing){

            0 ->{
                var breathingArrayadp = Breathingadpter(this,BreathingArray,bdraw)
                fragmentrecycler.adapter = breathingArrayadp
            }
            1 ->{
                var meditationadp = Meditationadp(this,Meditation,mdraw)
                fragmentrecycler.adapter = meditationadp
            }
            2->{
                var anxietyadp = Anxietyadp(this,Anxiety,adraw)
                fragmentrecycler.adapter = anxietyadp
            }
            3 ->{
                var affirmationadp = Affirmationadp(this,Affirmation,afdraw)
                fragmentrecycler.adapter = affirmationadp
            }
            4 ->{
                var selfCareadp = SelfCareadp(this,SelfCare,sedraw)
                fragmentrecycler.adapter = selfCareadp
            }
            5 ->{
                var stressReduceadp = StressReduceadp(this,StressReduce,sdraw)
                fragmentrecycler.adapter = stressReduceadp
            }


        }



    }
}