package com.example.serene.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.Drawernav.Physical_health
import com.example.serene.PhysicalGealthcategory.PhysicalHealthCatRecycler
import com.example.serene.R
import com.example.serene.SliderData


class P_HealthAdapter(
    private val plist: ArrayList<SliderData>,
   val  array: Array<Int>,
    var physicalHealth: Physical_health
) : RecyclerView.Adapter<P_HealthAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.forphysicalhealth_cat, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(pholder: ViewHolder, position: Int) {
        val Pitemviewmodel = plist[position]
        val image = array[position]

        pholder.ptext.text = Pitemviewmodel.array[position]
        pholder.imgg.setBackgroundResource(image)

        pholder.layout.setOnClickListener {
                    physicalHealth.startActivity(Intent(physicalHealth.context,PhysicalHealthCatRecycler::class.java).putExtra("data",position))
        }
    }
    override fun getItemCount(): Int {
        return plist.size
    }

    class ViewHolder(Sliderdata: View) : RecyclerView.ViewHolder(Sliderdata) {
        val ptext: TextView = itemView.findViewById(R.id.txt)
        val layout: RelativeLayout = itemView.findViewById(R.id.physiclrelative)
        val imgg: ImageView = itemView.findViewById(R.id.imgg)
    }
}

