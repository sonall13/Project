package com.example.serene.Bottumnavigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R
import com.example.serene.sleepHome.Alarm
import com.example.serene.sleepHome.BedtimeGoal
import com.example.serene.sleepHome.SleepGoal
import com.example.serene.sleepHome.Sleepadp


class SleepTrekarFregment : Fragment() {

    lateinit var b1 :Button
    lateinit var b2 :Button
    lateinit var b3 :Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var a= inflater.inflate(R.layout.fragment_sleep_trekar_fregment, container, false)

        val sleeprec = a.findViewById<RecyclerView>(R.id.sleeprec)
        val sleepdata = ArrayList<String>()
        val adapter = Sleepadp(sleepdata)
        sleeprec.adapter = adapter

        b1 = a.findViewById(R.id.b1)
        b2 = a.findViewById(R.id.b2)
        b3 = a.findViewById(R.id.b3)

        sleepdata.add("dlsm")
        sleepdata.add("dlsm")
        sleepdata.add("dlsm")
        sleepdata.add("dlsm")
        sleepdata.add("dlsm")
        sleepdata.add("dlsm")

        b1.setOnClickListener {
            var inte = Intent(context, SleepGoal::class.java)
            startActivity(inte)
        }
        b2.setOnClickListener {
            var inte = Intent(context, BedtimeGoal::class.java)
            startActivity(inte)
        }

        b3.setOnClickListener {
            var inte = Intent(context, Alarm::class.java)
            startActivity(inte)
        }


        return a
    }

}