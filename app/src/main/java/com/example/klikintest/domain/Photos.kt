package com.example.klikintest.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Photos (
    var _id:String?="",
    var format:String?="",
    var url:String?="",
    var thumbnails:Thumbnails?
):Serializable
