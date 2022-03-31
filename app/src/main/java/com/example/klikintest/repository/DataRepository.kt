package com.example.klikintest.repository


import android.content.Context
import android.location.Location
import com.example.klikintest.R
import com.example.klikintest.network.ErrorResponse
import com.example.klikintest.network.model.Commerces
import com.example.klikintest.ui.model.UiResult
import com.example.klikintest.usecases.BaseKoin
import com.example.klikintest.utils.toDomainCommerces
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.koin.core.component.inject

import retrofit2.Response

class DataRepository(val remoteDataSource: RemoteDataSource):BaseKoin {
     private val context : Context by inject()

     suspend fun getList(): UiResult {

          val currentLocation = getCurrentLocation()

          var uiResult = UiResult(null, "")
          var errorMessage: String = ""
          val gson = Gson()
          val type = object : TypeToken<ErrorResponse>() {}.type

          val result = remoteDataSource.getCommercesList()
          if (result.isSuccessful) {
               uiResult = UiResult(toDomainCommerces(result.body(), currentLocation), "")
          } else {
               val errorResponse: ErrorResponse? =
                    gson.fromJson(result.errorBody()!!.charStream(), type)
               errorMessage = errorResponse?.code.toString() + errorResponse?.message
               uiResult = UiResult(null, errorMessage)
          }
          return uiResult
     }

     private fun getCurrentLocation(): Location? {
          val sharedPref = context.getSharedPreferences("location", Context.MODE_PRIVATE)
          val latString = sharedPref.getString(context.getString(R.string.lat),"")
          val lonString = sharedPref.getString(context.getString(R.string.lon),"")
          var currentLocation : Location? = null
          if(latString!!.isNotEmpty() && lonString!!.isNotEmpty()){
               currentLocation= Location("One")
               currentLocation.latitude = latString.toDouble()
               currentLocation.longitude = lonString.toDouble()
          }
          return currentLocation
     }

}

interface RemoteDataSource {
     suspend fun getCommercesList(): Response<ArrayList<Commerces>?>
}
