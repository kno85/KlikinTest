package com.example.klikintest.network.model

import com.google.gson.annotations.SerializedName

data class Address (
    @SerializedName("zip")
    var zip:String?,
    @SerializedName("city")
    var city:String?,
    @SerializedName("country")
    var country:String?,
    @SerializedName("street")
    var street:String?
)
