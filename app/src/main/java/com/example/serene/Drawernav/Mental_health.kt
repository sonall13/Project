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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mental_health, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Mentalhealthcat.add("Breathing")
        Mentalhealthcat.add("Meditation")
        Mentalhealthcat.add("Anxiety")
        Mentalhealthcat.add("Affirmation")
        Mentalhealthcat.add("Self Care")
        Mentalhealthcat.add("Stress Reduce")

        mrecyclerview = view.findViewById(mrecyclerView)

        mrecyclerview.layoutManager = LinearLayoutManager(context)

        val data = ArrayList<SliderData>()

        for (i in 0..5) {
            data.add(SliderData("", "", 0, Mentalhealthcat, "", ""))
        }
        val adapter = M_HealthAdapter(data,this)

        mrecyclerview.adapter = adapter
    }


}



