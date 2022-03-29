package com.example.klikintest.network.model

import com.google.gson.annotations.SerializedName

class Logo(
    @SerializedName("url")
    var url:String?,
    @SerializedName("format")
    var format:String?,
    @SerializedName("thumbnails")
    var thumbnails:Thumbnails?
)