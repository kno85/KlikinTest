package com.example.klikintest.network.model

import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("small")
    var small:String?,
    @SerializedName("medium")
    var medium:String?,
    @SerializedName("large")
    var large:String?
)