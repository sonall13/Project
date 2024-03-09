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

    lateinit var dateTV: TextView

    var Progresscat = ArrayList<String>()
//    var progressarray = arrayOf("Journal" , "Moods" , "Yoga" , "Sleep" , "Stretching")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Progresscat.add("Journal")
        Progresscat.add("Moods")
        Progresscat.add("Yoga")
        Progresscat.add("Sleep")
        Progresscat.add("Stretching")
        Progresscat.add("Memories")

        // Inflate the layout for this fragment
        var a= inflater.inflate(R.layout.fragment_progress_fregment, container, false)

        dateTV = a.findViewById(R.id.idTVDate)
        val progresschart = a.findViewById<RecyclerView>(R.id.precycle)


        var z = Home_page()

        // this creates a vertical layout Manager
        progresschart.layoutManager = LinearLayoutManager(z)

        // ArrayList of class ItemsViewModel
        val psdata = ArrayList<SliderData>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 0..5) {
            psdata.add(SliderData( "","",0,Progresscat,"",""))
        }

        // This will pass the ArrayList to our Adapter
        val psadapter = Progressadp(psdata)

        // Setting the Adapter with the recyclerview
        progresschart.adapter = psadapter

    return a
    }


}