package com.example.klikintest.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Address (
    var zip:String?="",
    var city:String?="",
    var country:String?="",
    var street:String?=""
):Serializable
