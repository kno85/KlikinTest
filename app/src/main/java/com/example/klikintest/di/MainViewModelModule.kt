package com.example.klikintest.di

import com.example.klikintest.ui.main.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


    val MainViewModelModule = module {
                viewModel { HomeViewModel() }
    }
