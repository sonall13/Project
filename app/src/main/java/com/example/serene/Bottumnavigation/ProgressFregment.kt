package com.example.serene.Bottumnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.Home_page
import com.example.serene.Adapters.Progressadp
import com.example.serene.R
import com.example.serene.SliderData


class ProgressFregment : Fragment() {


    var Progresscat = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return   inflater.inflate(R.layout.fragment_progress_fregment, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Progresscat.add("Journal")
        Progresscat.add("Moods")
        Progresscat.add("Yoga")
        Progresscat.add("Sleep")
        Progresscat.add("Stretching")

        val progresschart = view.findViewById<RecyclerView>(R.id.precycle)

        progresschart.layoutManager = LinearLayoutManager(context)

        val psdata = ArrayList<SliderData>()
        for (i in 0..4) {
            psdata.add(SliderData( "","",0,Progresscat,"",""))
        }
        val psadapter = Progressadp(psdata)
        progresschart.adapter = psadapter
    }

}