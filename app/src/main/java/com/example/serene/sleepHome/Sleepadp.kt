package com.example.serene.sleepHome

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R

class Sleepadp(var sleepdata: ArrayList<String>, var sleepdraw: ArrayList<Int>, var context: Context?) : RecyclerView.Adapter<Sleepadp.Viewholder>() {
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

        holder.drawableimg.setOnClickListener {

            when (position) {


                0 -> context?.startActivity(Intent(context, Sleep_audio1::class.java))
                1 -> context?.startActivity(Intent(context, Sleep_audio2::class.java))
                2-> context?.startActivity(Intent(context, Sleep_audio3::class.java))
                3 -> context?.startActivity(Intent(context, Sleep_audio4::class.java))

            }

            // sets the image to the imageview from our itemHolder class
            // sets the text to the textview from our itemHolder class

//        holder.sleept.text = "hello"     }


        }
    }
}