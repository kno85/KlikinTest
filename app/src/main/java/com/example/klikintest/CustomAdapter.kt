package com.example.klikintest

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.bumptech.glide.Glide


class CustomAdapter(val placeList:List<Place>,val listener:viewActions) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

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
        fun bind(place: Place, listener: viewActions) {
            val imageView = itemView.findViewById<ImageView>(R.id.image)
            itemView.findViewById<TextView>(R.id.title).text= place.name
            itemView.findViewById<TextView>(R.id.description).text= place.description
            Glide.with(itemView.context).load(R.drawable.ic_launcher_background).into(imageView)
            itemView.setOnClickListener {listener.onItemClick(place.id!!)}
        }

    }

}
interface viewActions{
    fun onItemClick(itemId:Int)
}
