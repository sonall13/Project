package com.example.serene.Drawernav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.Adapters.M_HealthAdapter
import com.example.serene.Home_page
import com.example.serene.R
import com.example.serene.R.id.mrecyclerView
import com.example.serene.SliderData


class Mental_health : Fragment() {

    lateinit var   mrecyclerview : RecyclerView
    var Mentalhealthcat = ArrayList<String>()
//    var categorys = arrayOf("Breathing" , "Anxiety" ,"Affirmation" , "Meditation" , "Self Care" , "Stress Reduce")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        var av = inflater.inflate(R.layout.fragment_mental_health, container, false)

        var  activityy = Home_page()

        Mentalhealthcat.add("Breathing")
        Mentalhealthcat.add("Meditation")
        Mentalhealthcat.add("Anxiety")
        Mentalhealthcat.add("Affirmation")
        Mentalhealthcat.add("Self Care")
        Mentalhealthcat.add("Stress Reduce")

        // getting the recyclerview by its id
            mrecyclerview = av.findViewById(mrecyclerView)

        // this creates a vertical layout Manager
        mrecyclerview.layoutManager = LinearLayoutManager(activityy)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<SliderData>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 0..5) {
            data.add(SliderData("", "", 0, Mentalhealthcat, "", ""))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = M_HealthAdapter(data,this)

        // Setting the Adapter with the recyclerview
        mrecyclerview.adapter = adapter

        return av
    }


}



