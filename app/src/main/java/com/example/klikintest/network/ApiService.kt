package com.example.klikintest.network
import com.example.klikintest.network.model.Commerces
import retrofit2.Call
import retrofit2.http.GET



const val BASE_URL:String="http://prod.klikin.com"
const val CommercesEnpoint="/commerces/public"

interface ApiService {
    @GET(CommercesEnpoint)
    fun getCommerces(): Call <ArrayList<Commerces>>


}

