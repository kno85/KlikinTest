package com.example.klikintest.network.model

import com.google.gson.annotations.SerializedName

data class Contact (
    @SerializedName("phone")
    var zip:Int?,
    @SerializedName("email")
    var city:String?,
    @SerializedName("web")
    var country:String?
)
