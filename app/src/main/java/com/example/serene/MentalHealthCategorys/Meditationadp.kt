package com.example.serene.MentalHealthCategorys

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.MeditationActivity.Chakra
import com.example.serene.MeditationActivity.Concentrate
import com.example.serene.MeditationActivity.Focused
import com.example.serene.MeditationActivity.Mantra
import com.example.serene.MeditationActivity.MindFulness
import com.example.serene.MeditationActivity.SereneSoul
import com.example.serene.MeditationActivity.SereneSoulSpace
import com.example.serene.MeditationActivity.Spiritual
import com.example.serene.R

class Meditationadp(var context: M_CtegoryFragmentActivity,var meditation: ArrayList<String>,var drawablearray: ArrayList<Int>) : RecyclerView.Adapter<Meditationadp.ViewHolder>() {
    class ViewHolder(meditation: View) : RecyclerView.ViewHolder(meditation) {

        val meditation: TextView = itemView.findViewById(R.id.title)
        var drawableimg : ImageView = itemView.findViewById(R.id.drawableimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var formeditationRecycler = LayoutInflater.from(parent.context).inflate(R.layout.formeditationrecycler,parent,false)

        return ViewHolder(formeditationRecycler)
    }

    override fun getItemCount(): Int {


            return meditation.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.meditation.text = meditation[position]
        holder.drawableimg.setBackgroundResource(drawablearray[position])

        holder.drawableimg.setOnClickListener {

            when(position){
                0 -> context.startActivity(Intent(context,MindFulness::class.java))
                1 -> context.startActivity(Intent(context,Spiritual::class.java))
                2 -> context.startActivity(Intent(context,Focused::class.java))
                3 -> context.startActivity(Intent(context,Mantra::class.java))
                4 -> context.startActivity(Intent(context,Chakra::class.java))
                5 -> context.startActivity(Intent(context, Concentrate::class.java))
                6 -> context.startActivity(Intent(context, SereneSoul::class.java))
                7 -> context.startActivity(Intent(context, SereneSoulSpace::class.java))


            }

        }

    }

}
