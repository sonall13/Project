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
        return inflater.inflate(R.layout.fragment_sleep_trekar_fregment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val sleeprec = view.findViewById<RecyclerView>(R.id.sleeprec)
        val sleepdata = ArrayList<String>()
        val sleepdraw = ArrayList<Int>()
        val adapter = Sleepadp(sleepdata,sleepdraw)
        sleeprec.adapter = adapter

        sleepdraw.add(R.drawable.sleep6)
        sleepdraw.add(R.drawable.sleep5)
        sleepdraw.add(R.drawable.sleep3)
        sleepdraw.add(R.drawable.sleep4)
        sleepdraw.add(R.drawable.sleep2)
        sleepdraw.add(R.drawable.sleeep1)

        b1 = view.findViewById(R.id.b1)
        b2 = view.findViewById(R.id.b2)
        b3 = view.findViewById(R.id.b3)

//       sleepdata.add(R.drawable.sl1)
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
    }

}