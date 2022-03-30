package com.example.klikintest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.klikintest.R
import com.example.klikintest.domain.Commerces
import org.koin.androidx.viewmodel.ext.android.viewModel


const val ITEM: String="item"

class HomeFragment : Fragment(), viewActions {
    private lateinit var mview: View
    private val mainViewModel by viewModel<HomeViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mview = inflater.inflate(R.layout.fragment_main, container, false)
        setupView()
        return mview
    }

    private fun setupView() {
        val rV = mview.findViewById<RecyclerView>(R.id.rv)
        rV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mainViewModel.commercesList.observe(viewLifecycleOwner, Observer<List<Commerces>>() {
            rV.adapter = CustomAdapter(it, this)
        })
        mainViewModel.errorMessage.observe(viewLifecycleOwner, Observer<String>() {
            Toast.makeText(context,it, Toast.LENGTH_LONG).show()
        })
    }

    override fun onItemClick(item: Commerces) {
        val bundle = Bundle()
        bundle.putSerializable(ITEM, item)

        Navigation.findNavController(mview).navigate(R.id.action_myHomeFragment_to_detailFragment
            , bundle)
    }


}


