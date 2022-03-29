package com.example.klikintest.network.model

import com.google.gson.annotations.SerializedName

data class Config(
    @SerializedName("timezone")
    var timezone:String?,
    @SerializedName("currency")
    var currency:String?,
    @SerializedName("locale")
    var locale:String?
)