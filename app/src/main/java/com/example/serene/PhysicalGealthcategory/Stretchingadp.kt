package com.example.serene.PhysicalGealthcategory


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R
import com.example.serene.StretchingActivity.FlexEase
import com.example.serene.StretchingActivity.FlexFlow
import com.example.serene.StretchingActivity.FlexibilityFocus
import com.example.serene.StretchingActivity.StretchRevive
import com.example.serene.StretchingActivity.StretchSync

class Stretchingadp(var context: PhysicalHealthCatRecycler,var stretching: ArrayList<String>,var drawablearray: ArrayList<Int>) : RecyclerView.Adapter<Stretchingadp.ViewHolder>() {
    class ViewHolder(stretching: View):RecyclerView.ViewHolder(stretching) {

        val meditation: TextView = itemView.findViewById(R.id.title)
        var drawableimg : ImageView = itemView.findViewById(R.id.drawableimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var forPhysicalRcycler = LayoutInflater.from(parent.context).inflate(R.layout.forphysicalrcycler,parent,false)
        return ViewHolder(forPhysicalRcycler)
    }

    override fun getItemCount(): Int {
        return stretching.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.meditation.text = stretching[position]
        holder.drawableimg.setBackgroundResource(drawablearray[position])

        holder.drawableimg.setOnClickListener {

            when(position) {
                0 -> context.startActivity(Intent(context, FlexFlow::class.java))
                1 -> context.startActivity(Intent(context, StretchSync::class.java))
                2 -> context.startActivity(Intent(context, FlexEase::class.java))
                3 -> context.startActivity(Intent(context, StretchRevive::class.java))
                4 -> context.startActivity(Intent(context, FlexibilityFocus::class.java))

            }
        }
}

}
