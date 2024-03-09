package com.example.serene.PhysicalGealthcategory

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.ActiveAuraActivity.AuraActivator
import com.example.serene.ActiveAuraActivity.AuraAscend
import com.example.serene.ActiveAuraActivity.DynamicGlow
import com.example.serene.ActiveAuraActivity.EnergeticEden
import com.example.serene.ActiveAuraActivity.SparkSphere
import com.example.serene.R

class ActiveAuraadp(var context: PhysicalHealthCatRecycler,var activeAura: ArrayList<String>,var drawablearray: ArrayList<Int>) : RecyclerView.Adapter<ActiveAuraadp.ViewHolder>() {
    class ViewHolder(activeAura: View) : RecyclerView.ViewHolder(activeAura) {

        val activeAura: TextView = itemView.findViewById(R.id.title)
        var drawableimg : ImageView = itemView.findViewById(R.id.drawableimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var forPhysicalRcycler = LayoutInflater.from(parent.context).inflate(R.layout.forphysicalrcycler,parent,false)
        return ViewHolder(forPhysicalRcycler)
    }

    override fun getItemCount(): Int {
        return activeAura.size
      }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.activeAura.text = activeAura[position]
        holder.drawableimg.setBackgroundResource(drawablearray[position])

        holder.drawableimg.setOnClickListener {
        when(position) {

            0 -> context.startActivity(Intent(context, DynamicGlow::class.java))
            1 -> context.startActivity(Intent(context, AuraActivator::class.java))
            2 -> context.startActivity(Intent(context, AuraAscend::class.java))
            3 -> context.startActivity(Intent(context, SparkSphere::class.java))
            4 -> context.startActivity(Intent(context, EnergeticEden::class.java))

        }
        }

    }

}
