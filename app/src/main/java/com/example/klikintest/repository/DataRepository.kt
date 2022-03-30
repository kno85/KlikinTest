package com.example.klikintest.repository


import com.example.klikintest.network.ErrorResponse
import com.example.klikintest.network.model.Commerces
import com.example.klikintest.ui.model.UiResult
import com.example.klikintest.utils.toDomainCommerces
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import retrofit2.Response

class DataRepository(val remoteDataSource: RemoteDataSource) {

     suspend fun getList(): UiResult {
          var uiResult = UiResult(null, "")
          var errorMessage: String = ""
          val gson = Gson()
          val type = object : TypeToken<ErrorResponse>() {}.type

          val result = remoteDataSource.getCommercesList()
          if (result.isSuccessful) {
               uiResult = UiResult(toDomainCommerces(result.body()), "")
          } else {
               val errorResponse: ErrorResponse? =
                    gson.fromJson(result.errorBody()!!.charStream(), type)
               errorMessage = errorResponse?.code.toString() + errorResponse?.message
               uiResult = UiResult(null, errorMessage)
          }
          return uiResult
     }

}

interface RemoteDataSource {
     suspend fun getCommercesList(): Response<ArrayList<Commerces>?>
}
