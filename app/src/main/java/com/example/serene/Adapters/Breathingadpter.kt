package com.example.serene.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.BreathingActivity.AumChant
import com.example.serene.BreathingActivity.Calmcycles
import com.example.serene.BreathingActivity.DeStress
import com.example.serene.BreathingActivity.Deepdiaphragm
import com.example.serene.BreathingActivity.Serenepulse
import com.example.serene.BreathingActivity.SootheSphere
import com.example.serene.BreathingActivity.Wakeup
import com.example.serene.BreathingActivity.ZenBreath
import com.example.serene.MeditationActivity.Focused
import com.example.serene.MentalHealthCategorys.Anxiety
import com.example.serene.MentalHealthCategorys.M_CtegoryFragmentActivity
import com.example.serene.R

class Breathingadpter(
    var context: M_CtegoryFragmentActivity,
    var breathingcat: ArrayList<String>,
    var drawablearray: ArrayList<Int>
) :
    RecyclerView.Adapter<Breathingadpter.ViewHolder>() {
    class ViewHolder(breathingcat : View) : RecyclerView.ViewHolder(breathingcat){

        val breathingcatt: TextView = itemView.findViewById(R.id.title)
        var drawableimg : ImageView = itemView.findViewById(R.id.drawableimg)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var forBreathingcat = LayoutInflater.from(parent.context).inflate(R.layout.formeditationrecycler,parent,false)
        return ViewHolder(forBreathingcat)
    }

    override fun getItemCount(): Int {

        return breathingcat.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.breathingcatt.text = breathingcat[position]
        holder.drawableimg.setBackgroundResource(drawablearray[position])

        holder.drawableimg.setOnClickListener {

            when(position){
                0 -> context.startActivity(Intent(context,Deepdiaphragm::class.java))
                1 -> context.startActivity(Intent(context,AumChant::class.java))
                2 -> context.startActivity(Intent(context,DeStress::class.java))
                3 -> context.startActivity(Intent(context,Focused::class.java))
                4 -> context.startActivity(Intent(context,Wakeup::class.java))
                5 -> context.startActivity(Intent(context,Serenepulse::class.java))
                6 -> context.startActivity(Intent(context, SootheSphere::class.java))
                7 -> context.startActivity(Intent(context, ZenBreath::class.java))
                8 -> context.startActivity(Intent(context, Calmcycles::class.java))
            }

        }

    }
}