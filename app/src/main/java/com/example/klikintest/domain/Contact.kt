package com.example.klikintest.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Contact (
    var phone:String?="",
    var email:String?="",
    var web:String?=""
):Serializable
