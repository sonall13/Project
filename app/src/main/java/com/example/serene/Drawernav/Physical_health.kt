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
        // Inflate the layout for this fragment

        Physicalhealthcat.add("Stretching")
        Physicalhealthcat.add("Healthy Eating")
        Physicalhealthcat.add("Yoga")
        Physicalhealthcat.add("ActiveAura")
        Physicalhealthcat.add("VitalVibe")
        Physicalhealthcat.add("StaminaSculpt")

        var sd = inflater.inflate(R.layout.fragment_physical_health, container, false)

            physicalrecv = sd.findViewById(R.id.physicalrecv)
        var st = Home_page()

        // this creates a vertical layout Manager
        physicalrecv.layoutManager = LinearLayoutManager(st)

        // ArrayList of class ItemsViewModel
        val pdata = ArrayList<SliderData>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 0..5) {
            pdata.add(SliderData(" ", "", 0, Physicalhealthcat, " ", ""))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = P_HealthAdapter(pdata,this)

        // Setting the Adapter with the recyclerview
        physicalrecv.adapter = adapter

        return sd
    }

}