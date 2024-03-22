package com.example.serene.sleepHome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R

class Sleepadp(var sleepdata: ArrayList<String>, var sleepdraw: ArrayList<Int>) : RecyclerView.Adapter<Sleepadp.Viewholder>() {
    class Viewholder(sleepdata: View) : RecyclerView.ViewHolder(sleepdata) {

//        val sleept: TextView = itemView.findViewById(R.id.sleept)
        var drawableimg: ImageView = itemView.findViewById(R.id.drawableimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sleepcardview, parent, false)

        return Viewholder(view)
    }

    override fun getItemCount(): Int {
        return sleepdata.size

    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val sleepmodel = sleepdata[position]
        val sleepmodel2 = sleepdraw[position]
        holder.drawableimg.setBackgroundResource(sleepdraw[position])


        // sets the image to the imageview from our itemHolder class
        // sets the text to the textview from our itemHolder class

//        holder.sleept.text = "hello"     }


    }
}