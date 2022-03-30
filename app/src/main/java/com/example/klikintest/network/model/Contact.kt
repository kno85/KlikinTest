package com.example.klikintest.network.model

import com.google.gson.annotations.SerializedName

data class Contact (
    @SerializedName("phone")
    var phone:String?,
    @SerializedName("email")
    var email:String?,
    @SerializedName("web")
    var web:String?
)
