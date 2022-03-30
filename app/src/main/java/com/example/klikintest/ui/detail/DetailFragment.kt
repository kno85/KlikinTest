package com.example.klikintest.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.klikintest.R
import com.example.klikintest.domain.Commerces
import com.example.klikintest.ui.main.ITEM


class DetailFragment : Fragment() {
    private var item: Commerces? = null
    private lateinit var mview: View



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mview = inflater.inflate(R.layout.fragment_detail, container, false)
        item= arguments?.getSerializable(ITEM) as Commerces
        setupView()
        return mview
    }
    private fun setupView() {
        item.let {
            mview.findViewById<TextView>(R.id.detail_title).text=it?.name
            mview.findViewById<TextView>(R.id.detail_description).text=it?.description
            val imageView = mview.findViewById<ImageView>(R.id.detail_image)
            if(it?.photos?.size!! >0 && it.photos?.get(0)?.thumbnails?.medium!!.isNotEmpty()) {
                Glide.with(this).load(it?.photos?.get(0)?.thumbnails?.medium).into(imageView)

            }
        }

        }
}


