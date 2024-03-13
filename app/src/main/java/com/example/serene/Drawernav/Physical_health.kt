package com.example.serene.Drawernav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.Adapters.P_HealthAdapter
import com.example.serene.Home_page
import com.example.serene.R
import com.example.serene.SliderData


class Physical_health : Fragment()  {

    lateinit var physicalrecv : RecyclerView
    var Physicalhealthcat = ArrayList<String>()
//    var category1 = arrayOf("Stretching" , "Healthy Eating" , "Yoga")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
       return inflater.inflate(R.layout.fragment_physical_health, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Physicalhealthcat.add("Stretching")
        Physicalhealthcat.add("Healthy Eating")
        Physicalhealthcat.add("Yoga")
        Physicalhealthcat.add("ActiveAura")
        Physicalhealthcat.add("VitalVibe")
        Physicalhealthcat.add("StaminaSculpt")

        physicalrecv = view.findViewById(R.id.physicalrecv)

        physicalrecv.layoutManager = LinearLayoutManager(context)
        val pdata = ArrayList<SliderData>()
        for (i in 0..5) {
            pdata.add(SliderData(" ", "", 0, Physicalhealthcat, " ", ""))
        }
        val adapter = P_HealthAdapter(pdata,this)
        physicalrecv.adapter = adapter
    }

}