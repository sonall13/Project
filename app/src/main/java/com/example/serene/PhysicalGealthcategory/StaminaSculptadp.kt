package com.example.serene.PhysicalGealthcategory

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R
import com.example.serene.StaminaSculptActivity.CoreCharge
import com.example.serene.StaminaSculptActivity.SculptSquad
import com.example.serene.StaminaSculptActivity.SculptStrong
import com.example.serene.StaminaSculptActivity.SculptifyStrenght
import com.example.serene.StaminaSculptActivity.VigorVista

class StaminaSculptadp(var context: PhysicalHealthCatRecycler,var staminaSculpt: ArrayList<String>,var drawablearray: ArrayList<Int>) : RecyclerView.Adapter<StaminaSculptadp.ViewHolder>() {
    class ViewHolder(staminaSculpt: View) : RecyclerView.ViewHolder(staminaSculpt) {

        val staminaSculpt: TextView = itemView.findViewById(R.id.title)
        var drawableimg : ImageView = itemView.findViewById(R.id.drawableimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var forPhysicalRcycler = LayoutInflater.from(context).inflate(R.layout.forphysicalrcycler,parent,false)
        return ViewHolder(forPhysicalRcycler)
    }

    override fun getItemCount(): Int {
        return staminaSculpt.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.staminaSculpt.text = staminaSculpt[position]
        holder.drawableimg.setBackgroundResource(drawablearray[position])

        holder.drawableimg.setOnClickListener {
            when (position) {
                0 -> context.startActivity(Intent(context, CoreCharge::class.java))
                1 -> context.startActivity(Intent(context, SculptSquad::class.java))
                2 -> context.startActivity(Intent(context, SculptStrong::class.java))
                3 -> context.startActivity(Intent(context, VigorVista::class.java))
                4 -> context.startActivity(Intent(context, SculptifyStrenght::class.java))
            }
        }

    }

}
