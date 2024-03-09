package com.example.serene.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.Drawernav.Mental_health
import com.example.serene.MentalHealthCategorys.M_CtegoryFragmentActivity
import com.example.serene.R
import com.example.serene.SliderData

class M_HealthAdapter(private val mList: List<SliderData>,var mentalHealth: Mental_health): RecyclerView.Adapter<M_HealthAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.formentalhealth_cat, parent, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.array[position]

        holder.cat_layout.setOnClickListener {
              mentalHealth.startActivity(Intent(mentalHealth.context,M_CtegoryFragmentActivity::class.java).putExtra("breathing",position))
        }

    }
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(SliderData: View) : RecyclerView.ViewHolder(SliderData) {
        val textView: TextView = itemView.findViewById(R.id.txt)
        val cat_layout: RelativeLayout = itemView.findViewById(R.id.cat_layout)
    }
}
