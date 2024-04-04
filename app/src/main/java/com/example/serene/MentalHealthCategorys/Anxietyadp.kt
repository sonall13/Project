package com.example.serene.MentalHealthCategorys

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.AnxietyActivity.CalmWave
import com.example.serene.AnxietyActivity.Calmcare
import com.example.serene.AnxietyActivity.ComfortCove
import com.example.serene.AnxietyActivity.EaseAnx
import com.example.serene.AnxietyActivity.Harmonyheal
import com.example.serene.AnxietyActivity.InnerCalmness
import com.example.serene.AnxietyActivity.RelaxationRefuge
import com.example.serene.AnxietyActivity.SereneSupport
import com.example.serene.R

class Anxietyadp(var context: M_CtegoryFragmentActivity,var anxiety: ArrayList<String>,var drawablearray: ArrayList<Int>) : RecyclerView.Adapter<Anxietyadp.ViewHolder>() {
    class ViewHolder(anxiety: View) :RecyclerView.ViewHolder(anxiety) {

        val anxiety: TextView = itemView.findViewById(R.id.title)
        var drawableimg : ImageView = itemView.findViewById(R.id.drawableimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var formeditationRecycler = LayoutInflater.from(parent.context).inflate(R.layout.formeditationrecycler,parent,false)
        return ViewHolder(formeditationRecycler)
    }

    override fun getItemCount(): Int {
        return anxiety.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.anxiety.text = anxiety[position]
        holder.drawableimg.setBackgroundResource(drawablearray[position])

        holder.drawableimg.setOnClickListener {

            when(position){
                0 -> context.startActivity(Intent(context, SereneSupport::class.java))
                1 -> context.startActivity(Intent(context, InnerCalmness::class.java))
                2 -> context.startActivity(Intent(context, Harmonyheal::class.java))
                3 -> context.startActivity(Intent(context, Calmcare::class.java))
                4 -> context.startActivity(Intent(context, RelaxationRefuge::class.java))
                5 -> context.startActivity(Intent(context, CalmWave::class.java))
                6 -> context.startActivity(Intent(context, EaseAnx::class.java))


            }
        }

    }

}
