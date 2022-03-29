package com.example.klikintest.network
import CharactersBuilder.apiRest
import com.example.klikintest.network.model.Commerces
import com.example.klikintest.repository.RemoteDataSource
import retrofit2.Response
import kotlin.random.Random

class RetrofitDataSource : RemoteDataSource {


    override suspend fun getCommercesList(): Response<ArrayList<Commerces>?> {
        return  apiRest.getCommerces().execute()

    }


}



