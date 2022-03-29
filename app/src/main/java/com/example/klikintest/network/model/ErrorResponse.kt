package com.example.klikintest.network

import com.google.gson.annotations.SerializedName

class ErrorResponse {
    @SerializedName("code")
    var code = 0
    @SerializedName("status")
    var message: String? = null
}