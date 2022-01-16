package com.hiteshchopra.ktorclientdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hiteshchopra.ktorclientdemo.ImagesAdapter.ImagesViewHolder
import com.hiteshchopra.ktorclientdemo.data.model.ImageResponseItem

class ImagesAdapter(private val list: ArrayList<ImageResponseItem>) :
  RecyclerView.Adapter<ImagesViewHolder>() {

  class ImagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(imageDetails: ImageResponseItem) {
      val imageView = itemView.findViewById<ImageView>(R.id.iv_photo)
      val description = itemView.findViewById<TextView>(R.id.tv_description)

      imageView.load(imageDetails.urls?.regular)
      description.text = imageDetails.description
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
    return ImagesViewHolder(
      LayoutInflater.from(parent.context).inflate(R.layout.item_photo_details, parent,false)
    )
  }

  override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
    holder.bind(list[position])
  }

  override fun getItemCount(): Int = list.size
}