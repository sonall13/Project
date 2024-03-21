package com.example.serene.GetData

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.R

class CategoryAdapter(private val categories: List<String>, private val onItemClick: (Int) -> Unit) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var selectedIndex: Int = RecyclerView.NO_POSITION

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryText: TextView = itemView.findViewById(R.id.categoryName)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    selectedIndex = position
                    notifyDataSetChanged() // Refresh the entire list to update UI
                    onItemClick(position)
                }
            }
        }

        fun bind(category: String, isSelected: Boolean) {
            categoryText.text = category
            itemView.isSelected = isSelected // Set the selected state of the item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val isSelected = position == selectedIndex
        holder.bind(categories[position], isSelected)    }

    override fun getItemCount(): Int {
        return categories.size
    }

}