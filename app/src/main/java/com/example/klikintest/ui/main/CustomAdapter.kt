package com.example.klikintest.ui.main

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.example.klikintest.R
import com.example.klikintest.domain.Commerces


class CustomAdapter(val placeList: List<Commerces>, val listener: viewActions) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parentView: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parentView.context)
            .inflate(R.layout.place_row, parentView, false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(placeList[position], listener)
    }

    override fun getItemCount(): Int= placeList.size

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(commerce: Commerces, listener: viewActions) {
            val imageView = itemView.findViewById<ImageView>(R.id.image)
            itemView.findViewById<TextView>(R.id.title).text= commerce.name
            itemView.findViewById<TextView>(R.id.distance).text= commerce.distance
            itemView.findViewById<TextView>(R.id.description).text= commerce.description
            if(commerce.photos?.size!! >0 && commerce.photos?.get(0)?.thumbnails?.medium!!.isNotEmpty()) {
                Glide.with(itemView.context).load(commerce.photos?.get(0)?.thumbnails?.medium)
                    .into(imageView)
            }
            itemView.setOnClickListener {listener.onItemClick(commerce)}
        }

    }

}
interface viewActions{
    fun onItemClick(commerce : Commerces)
}
