package com.example.serene.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R
import com.example.serene.SliderData

class Progressadp(private val pslist: ArrayList<SliderData>) :
    RecyclerView.Adapter<Progressadp.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.forprogresscardview, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val psviewmodel = pslist[position]

        // sets the image to the imageview from our itemHolder class

        // sets the text to the textview from our itemHolder class
        holder.ptext.text = psviewmodel.array[position]
    }

    override fun getItemCount(): Int {
        return pslist.size
    }
    class ViewHolder(Sliderdata: View) : RecyclerView.ViewHolder(Sliderdata) {
        val ptext: TextView = itemView.findViewById(R.id.ptexts)
    }

}
