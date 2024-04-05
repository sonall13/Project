package com.example.serene.PhysicalGealthcategory

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R
import com.example.serene.StaminaSculptActivity.Energize
import com.example.serene.StaminaSculptActivity.RadiantRhythms
import com.example.serene.StaminaSculptActivity.VibrantVista
import com.example.serene.StaminaSculptActivity.VitalFlow
import com.example.serene.StaminaSculptActivity.VitalSpark
import com.example.serene.StaminaSculptActivity.VitalityVortex

class VitalVibeadp(var context: PhysicalHealthCatRecycler,var vitalVibe: ArrayList<String>,var drawablearray: ArrayList<Int>) : RecyclerView.Adapter<VitalVibeadp.ViewHolder>() {
    class ViewHolder(vitalVibe: View):RecyclerView.ViewHolder(vitalVibe) {
        val vitalVibe: TextView = itemView.findViewById(R.id.title)
        var drawableimg : ImageView = itemView.findViewById(R.id.drawableimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var forPhysicalRcycler = LayoutInflater.from(parent.context).inflate(R.layout.forphysicalrcycler,parent,false)
        return ViewHolder(forPhysicalRcycler)
    }

    override fun getItemCount(): Int {
            return vitalVibe.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vitalVibe.text = vitalVibe[position]
        holder.drawableimg.setBackgroundResource(drawablearray[position])

        holder.drawableimg.setOnClickListener {
            when (position) {
                0 -> context.startActivity(Intent(context, RadiantRhythms::class.java))
                1 -> context.startActivity(Intent(context, VibrantVista::class.java))
                2 -> context.startActivity(Intent(context, VitalSpark::class.java))
                3 -> context.startActivity(Intent(context, VitalFlow::class.java))
                4 -> context.startActivity(Intent(context, Energize::class.java))
                5 -> context.startActivity(Intent(context, VitalityVortex::class.java))
            }
        }
    }

}
