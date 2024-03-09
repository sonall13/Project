package com.example.serene.PhysicalGealthcategory

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R
import com.example.serene.YogaActivity.AnlomVilom
import com.example.serene.YogaActivity.NamasteNest
import com.example.serene.YogaActivity.OmOasis
import com.example.serene.YogaActivity.SereneAsanas
import com.example.serene.YogaActivity.SuryaNamskar
import com.example.serene.YogaActivity.YogaEssence
import com.example.serene.YogaActivity.YogaVibe
import com.example.serene.YogaActivity.Yogicjourney
import com.example.serene.YogaActivity.yogazen

class Yoga_adp(var context: PhysicalHealthCatRecycler,var yoga: ArrayList<String>,var drawablearray: ArrayList<Int>) : RecyclerView.Adapter<Yoga_adp.ViewHolder>() {
    class ViewHolder(yoga: View):RecyclerView.ViewHolder(yoga) {

        val meditation: TextView = itemView.findViewById(R.id.title)
        var drawableimg : ImageView = itemView.findViewById(R.id.drawableimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var forPhysicalRcycler = LayoutInflater.from(parent.context).inflate(R.layout.forphysicalrcycler,parent,false)
        return ViewHolder(forPhysicalRcycler)
    }

    override fun getItemCount(): Int {
        return yoga.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.meditation.text = yoga[position]
        holder.drawableimg.setBackgroundResource(drawablearray[position])

        holder.drawableimg.setOnClickListener {

            when(position){
                0 -> context.startActivity(Intent(context, yogazen::class.java))
                1 -> context.startActivity(Intent(context, YogaVibe::class.java))
                2 -> context.startActivity(Intent(context, NamasteNest::class.java))
                3 -> context.startActivity(Intent(context, SereneAsanas::class.java))
                4 -> context.startActivity(Intent(context, Yogicjourney::class.java))
                5 -> context.startActivity(Intent(context, YogaEssence::class.java))
                6 -> context.startActivity(Intent(context, OmOasis::class.java))
                7 -> context.startActivity(Intent(context, SuryaNamskar::class.java))
                8 -> context.startActivity(Intent(context, AnlomVilom::class.java))

            }
        }
}

}
