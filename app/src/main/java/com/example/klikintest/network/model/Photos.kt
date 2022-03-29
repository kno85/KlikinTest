package com.example.klikintest.network.model

import com.google.gson.annotations.SerializedName

data class Photos (
    @SerializedName("_id")
    var _id:String?,
    @SerializedName("format")
    var format:String?,
    @SerializedName("url")
    var url:String?,
    @SerializedName("thumbnails")
    var thumbnails:Thumbnails?
)
