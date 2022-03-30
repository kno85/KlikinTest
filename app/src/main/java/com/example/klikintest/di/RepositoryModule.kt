package com.example.klikintest.di


import com.example.klikintest.repository.DataRepository
import com.example.klikintest.repository.RemoteDataSource
import org.koin.dsl.module

val RepositoryModule = module {
        fun provideUserRepository(dataSource: RemoteDataSource): DataRepository {
            return DataRepository(dataSource)
    }
        single { provideUserRepository(get()) }
    }
