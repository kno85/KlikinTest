package com.example.klikintest.domain

import com.google.gson.annotations.SerializedName

data class Config(
    var timezone:String?="",
    var currency:String?="",
    var locale:String?=""
)