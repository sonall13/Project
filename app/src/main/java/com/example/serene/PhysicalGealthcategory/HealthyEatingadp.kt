package com.example.serene.PhysicalGealthcategory

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.HealthyEatingActivity.BalancedBite
import com.example.serene.HealthyEatingActivity.CleanCuisine
import com.example.serene.HealthyEatingActivity.CleanEatsCorner
import com.example.serene.HealthyEatingActivity.HealthfulHaven
import com.example.serene.HealthyEatingActivity.NutriNova
import com.example.serene.HealthyEatingActivity.VibrantVeggies
import com.example.serene.HealthyEatingActivity.WholesomeWell
import com.example.serene.R

class HealthyEatingadp(var context: PhysicalHealthCatRecycler,var healthyEating: ArrayList<String>,var drawablearray: ArrayList<Int>) : RecyclerView.Adapter<HealthyEatingadp.ViewHolder>() {
    class ViewHolder(healthyEating: View):RecyclerView.ViewHolder(healthyEating) {

        val meditation: TextView = itemView.findViewById(R.id.title)
        var drawableimg : ImageView = itemView.findViewById(R.id.drawableimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var forPhysicalRcycler = LayoutInflater.from(parent.context).inflate(R.layout.forphysicalrcycler,parent,false)
        return ViewHolder(forPhysicalRcycler)
    }

    override fun getItemCount(): Int {
        return healthyEating.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.meditation.text = healthyEating[position]
        holder.drawableimg.setBackgroundResource(drawablearray[position])

        holder.drawableimg.setOnClickListener {

            when(position){

                0 -> context.startActivity(Intent(context, WholesomeWell::class.java))
                1 -> context.startActivity(Intent(context, CleanEatsCorner::class.java))
                2 -> context.startActivity(Intent(context, VibrantVeggies::class.java))
                3 -> context.startActivity(Intent(context, NutriNova::class.java))
                4 -> context.startActivity(Intent(context, HealthfulHaven::class.java))
                5 -> context.startActivity(Intent(context, CleanCuisine::class.java))
                6 -> context.startActivity(Intent(context, BalancedBite::class.java))

            }
        }
}

}
