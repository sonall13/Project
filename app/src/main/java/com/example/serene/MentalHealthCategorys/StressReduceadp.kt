package com.example.serene.MentalHealthCategorys

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R
import com.example.serene.SelfCare.SerenitySelf
import com.example.serene.StressReduce.ChillOutCove
import com.example.serene.StressReduce.PeacefulPause
import com.example.serene.StressReduce.RelaxationRealm
import com.example.serene.StressReduce.SereneSanctuary
import com.example.serene.StressReduce.SereneSolutions
import com.example.serene.StressReduce.StressBusterHub
import com.example.serene.StressReduce.StressEase
import com.example.serene.StressReduce.StressFreeZone

class StressReduceadp(var contaxt: M_CtegoryFragmentActivity,var stressReduce: ArrayList<String>,var drawablearray: ArrayList<Int>) : RecyclerView.Adapter<StressReduceadp.ViewHolder>() {
    class ViewHolder(stressreduce : View):RecyclerView.ViewHolder(stressreduce) {

        val meditation: TextView = itemView.findViewById(R.id.title)
        var drawableimg : ImageView = itemView.findViewById(R.id.drawableimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var forstressreduceRecycler = LayoutInflater.from(parent.context).inflate(R.layout.formeditationrecycler,parent,false)

        return ViewHolder(forstressreduceRecycler)
    }

    override fun getItemCount(): Int {
        return stressReduce.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.meditation.text = stressReduce[position]
        holder.drawableimg.setBackgroundResource(drawablearray[position])

        holder.drawableimg.setOnClickListener {
        when (position) {
            0 -> contaxt.startActivity(Intent(contaxt, ChillOutCove::class.java))
            1 -> contaxt.startActivity(Intent(contaxt, PeacefulPause::class.java))
            2 -> contaxt.startActivity(Intent(contaxt, RelaxationRealm::class.java))
            3 -> contaxt.startActivity(Intent(contaxt, SereneSanctuary::class.java))
            4 -> contaxt.startActivity(Intent(contaxt, SereneSolutions::class.java))
            5 -> contaxt.startActivity(Intent(contaxt, StressBusterHub::class.java))
            6 -> contaxt.startActivity(Intent(contaxt, StressEase::class.java))
            6 -> contaxt.startActivity(Intent(contaxt, StressFreeZone::class.java))
        }
    }
    }

}
