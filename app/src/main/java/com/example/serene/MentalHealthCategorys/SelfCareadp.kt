package com.example.serene.MentalHealthCategorys

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R
import com.example.serene.SelfCare.BlissfulBreak
import com.example.serene.SelfCare.CalmCoCoon
import com.example.serene.SelfCare.EmpowermentEden
import com.example.serene.SelfCare.SelfCareSage
import com.example.serene.SelfCare.SerenitySelf
import com.example.serene.SelfCare.TranquiTouches

class SelfCareadp(var context: M_CtegoryFragmentActivity,var selfCare: ArrayList<String>,var drawablearray: ArrayList<Int>) : RecyclerView.Adapter<SelfCareadp.ViewHolder>() {
    class ViewHolder(selfcare : View):RecyclerView.ViewHolder(selfcare) {

        val selfcare: TextView = itemView.findViewById(R.id.title)
        var drawableimg : ImageView = itemView.findViewById(R.id.drawableimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var forselfcareRecycler = LayoutInflater.from(parent.context).inflate(R.layout.formeditationrecycler,parent,false)

        return ViewHolder(forselfcareRecycler)
    }

    override fun getItemCount(): Int {
        return selfCare.size    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.selfcare.text = selfCare[position]
        holder.drawableimg.setBackgroundResource(drawablearray[position])

        holder.drawableimg.setOnClickListener {

            when (position) {

                0 -> context.startActivity(Intent(context, SerenitySelf::class.java))
                1 -> context.startActivity(Intent(context, SelfCareSage::class.java))
                2 -> context.startActivity(Intent(context, EmpowermentEden::class.java))
                3 -> context.startActivity(Intent(context, CalmCoCoon::class.java))
                4 -> context.startActivity(Intent(context, TranquiTouches::class.java))
                5 -> context.startActivity(Intent(context, BlissfulBreak::class.java))
            }
        }
    }

}
