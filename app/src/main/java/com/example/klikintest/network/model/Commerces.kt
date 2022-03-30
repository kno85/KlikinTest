package com.example.klikintest.network.model

import com.google.gson.annotations.SerializedName

data class Commerces(
    @SerializedName("slug")
    var slug:String?,
    @SerializedName("address")
    var address: Address?,
    @SerializedName("contact")
    var contact:Contact?,
    @SerializedName("social")
    var social:Social?,
    @SerializedName("name")
    var name:String?,
    @SerializedName("openingHours")
    var openingHours:String?,
    @SerializedName("shortDescription")
    var shortDescription:String?,
    @SerializedName("description")
    var description:String?,
    @SerializedName("minLegalAge")
    var minLegalAge:Int?,
    @SerializedName("ownerId")
    var ownerId:String?,
    @SerializedName("contractId")
    var contractId:String?,
    @SerializedName("pointsGroupId")
    var pointsGroupId:String?,
    @SerializedName("franchiseId")
    var franchiseId:String?,
    @SerializedName("photos")
    var photos:ArrayList<Photos>?,
    @SerializedName("logo")
    var logo:Logo?,
    @SerializedName("config")
    var config:Config?,
    @SerializedName("oldYoin")
    var oldYoin:Boolean?,
    @SerializedName("whiteLabel")
    var whiteLabel:Boolean?,
    @SerializedName("pos")
    var pos:Boolean?,
    @SerializedName("ipad")
    var ipad:Boolean?,
    @SerializedName("surveyRequired")
    var surveyRequired:Boolean?,
    @SerializedName("features")
    var features:ArrayList<String>?,
    @SerializedName("active")
    var active:Boolean?,
    @SerializedName("id")
    var id:String?,
    @SerializedName("latitude")
    var latitude:String?,
    @SerializedName("longitude")
    var longitude:String?
)