package com.example.klikintest.repository


import com.example.klikintest.network.model.Commerces

import retrofit2.Response

class DataRepository(val remoteDataSource: RemoteDataSource) {



}

interface RemoteDataSource {
     suspend fun getCommercesList(): Response<ArrayList<Commerces>?>
}
