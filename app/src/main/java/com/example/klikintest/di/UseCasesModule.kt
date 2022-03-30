package com.example.klikintest.di

import com.example.klikintest.usecases.UseCases
import org.koin.dsl.module

val UseCasesModule = module {
    factory {
        UseCases(get())
    }
}