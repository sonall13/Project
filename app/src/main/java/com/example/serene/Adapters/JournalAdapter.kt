package com.example.serene.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.JournalingActivity.FreeStyle
import com.example.serene.JournalingActivity.Gratitude
import com.example.serene.JournalingActivity.Memories
import com.example.serene.JournalingActivity.MorningJournal
import com.example.serene.JournalingActivity.NightJournalActivity
import com.example.serene.R
import com.example.serene.SliderData

class JournalAdapter(private val jlist: ArrayList<SliderData>, var context: Context?) :
    RecyclerView.Adapter<JournalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.forjournal_cat, parent, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jdataclass = jlist[position]

        // sets the image to the imageview from our itemHolder class
        // sets the text to the textview from our itemHolder class
        holder.jtext.text = jdataclass.array[position]

        holder.jtext.setOnClickListener {

            when(position){

                0 -> context!!.startActivity(Intent(context,MorningJournal::class.java))
                1 -> context!!.startActivity(Intent(context,NightJournalActivity::class.java))
                2 -> context!!.startActivity(Intent(context,Gratitude::class.java))
                3 -> context!!.startActivity(Intent(context,FreeStyle::class.java))
                4 -> context!!.startActivity(Intent(context,Memories::class.java))
            }
        }
    }
    override fun getItemCount(): Int {
        return jlist.size
    }
    class ViewHolder(Sliderdata: View) : RecyclerView.ViewHolder(Sliderdata) {

        val jtext: TextView = itemView.findViewById(R.id.jtexts)
    }

}
