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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_journaling_fregment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val journaling = view.findViewById<RecyclerView>(R.id.jrecycle)

        Journalingcat.add("Morning")
        Journalingcat.add("Night")
        Journalingcat.add("gratitude")
        Journalingcat.add("Free Style")
        Journalingcat.add("Memories")

        journaling.layoutManager = LinearLayoutManager(context)

        val jdata = ArrayList<SliderData>()

        for (i in 0..4) {
            jdata.add(SliderData( "","",0,Journalingcat,"",""))
        }
        val adapter = JournalAdapter(jdata,context)
        journaling.adapter = adapter
    }
}