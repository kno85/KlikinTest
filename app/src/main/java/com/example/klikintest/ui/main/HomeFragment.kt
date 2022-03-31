package com.example.klikintest.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.klikintest.R
import com.example.klikintest.domain.Commerces
import com.example.klikintest.ui.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


const val ITEM: String="item"

class HomeFragment : Fragment(), viewActions {
    private var nComerciosRightView: ImageView?=null
    private var nComerciosRightTextView: TextView?=null
    private var nComerciosLeftTextView: TextView?=null
    private lateinit var rV: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var mview: View
    private val mainViewModel by viewModel<HomeViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mview = inflater.inflate(R.layout.fragment_main, container, false)
        setupView()
        return mview
    }

    private fun setupView() {
         rV = mview.findViewById<RecyclerView>(R.id.rv)
         nComerciosLeftTextView = mview.findViewById<TextView>(R.id.ncomerciosLeft)
         nComerciosRightTextView = mview.findViewById<TextView>(R.id.ncomerciosRight)
         nComerciosRightView = mview.findViewById<ImageView>(R.id.imageView2)
        swipeRefreshLayout = mview.findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener(refreshListener);

        rV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        loadData()
    }

    private fun loadData() {
        mainViewModel.submitHeroList()
        mainViewModel.shortCommercesList.observe(viewLifecycleOwner, Observer<List<Commerces>>() {
            nComerciosRightTextView?.setText(it.size.toString())
        })
        mainViewModel.commercesList.observe(viewLifecycleOwner, Observer<List<Commerces>>() {
            swipeRefreshLayout.isRefreshing = false
            rV.adapter = CustomAdapter(it, this)
            nComerciosLeftTextView?.setText(it.size.toString())
        })

        mainViewModel.errorMessage.observe(viewLifecycleOwner, Observer<String>() {
            swipeRefreshLayout.isRefreshing = false
            Toast.makeText(context,it, Toast.LENGTH_LONG).show()
        })
    }

    override fun onItemClick(item: Commerces) {
        val bundle = Bundle()
        bundle.putSerializable(ITEM, item)

        Navigation.findNavController(mview).navigate(R.id.action_myHomeFragment_to_detailFragment
            , bundle)
    }
    private val refreshListener = SwipeRefreshLayout.OnRefreshListener {
        swipeRefreshLayout?.isRefreshing = true
        var mainActivity = activity as MainActivity
        mainActivity.requestLocationPermission()
        loadData()
    }

}


