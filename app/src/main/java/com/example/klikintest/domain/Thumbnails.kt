package com.example.klikintest.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Thumbnails(
    var small:String?="",
    var medium:String?="",
    var large:String?=""
):Serializable