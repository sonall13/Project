package com.example.serene.Bottumnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.Adapters.JournalAdapter
import com.example.serene.R
import com.example.serene.SliderData

class JournalingFregment : Fragment() {

    var  Journalingcat = ArrayList<String>()
//    var Journalcat = arrayOf("Morning" , "Night" , "gratitude" , "Free Style")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Journalingcat.add("Morning")
        Journalingcat.add("Night")
        Journalingcat.add("gratitude")
        Journalingcat.add("Free Style")
        Journalingcat.add("Memories")

        // Inflate the layout for this fragment
        var f= inflater.inflate(R.layout.fragment_journaling_fregment, container, false)


        val journaling = f.findViewById<RecyclerView>(R.id.jrecycle)

        // this creates a vertical layout Manager
//        var q= Home_page()
        journaling.layoutManager = LinearLayoutManager(context)

        // ArrayList of class ItemsViewModel
        val jdata = ArrayList<SliderData>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 0..4) {
            jdata.add(SliderData( "","",0,Journalingcat,"",""))
        }
        // This will pass the ArrayList to our Adapter
        val adapter = JournalAdapter(jdata,context)
        // Setting the Adapter with the recyclerview
        journaling.adapter = adapter

        return f
    }
}