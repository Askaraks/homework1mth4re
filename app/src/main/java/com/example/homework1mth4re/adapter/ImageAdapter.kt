package com.example.homework1mth4re.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1mth4re.R

class ImageAdapter(private val images: List<Drawable>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private val selectedPositions = mutableSetOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]
        holder.imageView.setImageDrawable(image)
        holder.itemView.isSelected = selectedPositions.contains(position)
        holder.itemView.setOnClickListener {
            if (selectedPositions.contains(position)) {
                selectedPositions.remove(position)
                holder.itemView.isSelected = false
            } else {
                selectedPositions.add(position)
                holder.itemView.isSelected = true
            }
        }
    }

    override fun getItemCount() = images.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}
