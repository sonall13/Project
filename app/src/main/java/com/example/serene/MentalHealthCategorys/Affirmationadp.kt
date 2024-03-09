package com.example.serene.MentalHealthCategorys

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.AffirmationActivity.AffirmArcade
import com.example.serene.AffirmationActivity.AffirmativeAura
import com.example.serene.AffirmationActivity.DreamDestiny
import com.example.serene.AffirmationActivity.EncourageU
import com.example.serene.AffirmationActivity.GlowUpGrove
import com.example.serene.AffirmationActivity.InspireInfinity
import com.example.serene.AffirmationActivity.ResilienceRise
import com.example.serene.AffirmationActivity.ZenAffirm
import com.example.serene.R

class Affirmationadp(var context: M_CtegoryFragmentActivity,var affirmation: ArrayList<String>,var drawablearray: ArrayList<Int>) : RecyclerView.Adapter<Affirmationadp.ViewHolder>() {
    class ViewHolder (affirmation: View):RecyclerView.ViewHolder(affirmation) {

        val affirmation: TextView = itemView.findViewById(R.id.title)
        var drawableimg : ImageView = itemView.findViewById(R.id.drawableimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var foraffirmationRecycler = LayoutInflater.from(parent.context).inflate(R.layout.formeditationrecycler,parent,false)

        return ViewHolder(foraffirmationRecycler)
    }

    override fun getItemCount(): Int {
        return affirmation.size    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.affirmation.text = affirmation[position]
        holder.drawableimg.setBackgroundResource(drawablearray[position])

        holder.drawableimg.setOnClickListener {
        when(position) {

            0 -> context.startActivity(Intent(context, GlowUpGrove::class.java))
            1 -> context.startActivity(Intent(context, DreamDestiny::class.java))
            2 -> context.startActivity(Intent(context, ResilienceRise::class.java))
            3 -> context.startActivity(Intent(context, AffirmArcade::class.java))
            4 -> context.startActivity(Intent(context, InspireInfinity::class.java))
            5 -> context.startActivity(Intent(context, ZenAffirm::class.java))
            6 -> context.startActivity(Intent(context, AffirmativeAura::class.java))
            7 -> context.startActivity(Intent(context, EncourageU::class.java))

        }
        }

    }

}
