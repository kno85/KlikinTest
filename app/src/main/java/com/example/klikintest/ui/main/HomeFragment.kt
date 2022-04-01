package com.example.klikintest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
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
    private lateinit var mainView: View
    private var nComerciosLeftView: ImageView?=null
    private var nComerciosRightView: ImageView?=null
    private var nComerciosRightTextView: TextView?=null
    private var nComerciosLeftTextView: TextView?=null
    private lateinit var rV: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private val mainViewModel by viewModel<HomeViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val mview = inflater.inflate(R.layout.fragment_main, container, false)
        mainView= mview
        setupView(mview)
        return mview
    }

    private fun setupView(mview: View) {
        rV = mview.findViewById<RecyclerView>(R.id.rv)
        nComerciosLeftTextView = mview.findViewById<TextView>(R.id.ncomerciosLeft)
        nComerciosRightTextView = mview.findViewById<TextView>(R.id.ncomerciosRight)
        nComerciosRightView = mview.findViewById<ImageView>(R.id.imageView2)
        nComerciosLeftView = mview.findViewById<ImageView>(R.id.imageView1)
        swipeRefreshLayout = mview.findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener(refreshListener);

        rV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        loadData()
    }

    private fun loadData() {
        mainViewModel.shortCommercesList.observe(viewLifecycleOwner, Observer<List<Commerces>>() {
            swipeRefreshLayout.isRefreshing = false
            nComerciosRightTextView?.setText(it.size.toString())
        })

        mainViewModel.commercesList.observe(viewLifecycleOwner, Observer<List<Commerces>>() {
            swipeRefreshLayout.isRefreshing = false
            nComerciosLeftTextView?.setText(it.size.toString())
            rV.adapter = CustomAdapter(it, this)
        })
        mainViewModel.errorMessage.observe(viewLifecycleOwner, Observer<String>() {
            swipeRefreshLayout.isRefreshing = false
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        })
        nComerciosRightView?.setOnClickListener {
            mainViewModel.shortCommercesList.observe(
                viewLifecycleOwner,
                Observer<List<Commerces>>() {
                    if (!it.isNullOrEmpty()) {
                        nComerciosRightView!!.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.blue))
                        nComerciosLeftView!!.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.black))

                                rV.adapter = CustomAdapter(it, this)
                    }
                })
        }
        nComerciosLeftView?.setOnClickListener {
            mainViewModel.commercesList.observe(
                viewLifecycleOwner,
                Observer<List<Commerces>>() {
                    if (!it.isNullOrEmpty()) {
                        nComerciosRightView!!.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.black))
                        nComerciosLeftView!!.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.blue))
                        rV.adapter = CustomAdapter(it, this)
                    }
                })
        }
    }

    override fun onItemClick(item: Commerces) {
        val bundle = Bundle()
        bundle.putSerializable(ITEM, item)

        mainView.let {
            Navigation.findNavController(it).navigate(R.id.action_myHomeFragment_to_detailFragment, bundle)
        }
    }
    private val refreshListener = SwipeRefreshLayout.OnRefreshListener {
        swipeRefreshLayout.isRefreshing = true
        val mainActivity = activity as MainActivity
        mainActivity.requestLocationPermission()
        loadData()
    }

}


