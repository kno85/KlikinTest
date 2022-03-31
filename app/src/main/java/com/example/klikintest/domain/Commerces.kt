package com.example.klikintest.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Commerces(
    var slug:String?="",
    var address: Address?,
    var contact:Contact?,
    var social:Social?,
    var name:String?="",
    var openingHours:String?="",
    var shortDescription:String?="",
    var description:String?="",
    var minLegalAge:Int?=0,
    var ownerId:String?="",
    var contractId:String?="",
    var pointsGroupId:String?="",
    var franchiseId:String?="",
    var photos:ArrayList<Photos>?,
    var logo:Logo?,
    var config:Config?,
    var oldYoin:Boolean?=false,
    var whiteLabel:Boolean?=false,
    var pos:Boolean?=false,
    var ipad:Boolean?=false,
    var surveyRequired:Boolean?=false,
    var features:ArrayList<String>?= ArrayList<String>(),
    var active:Boolean?=false,
    var id:String?="",
    var latitude:String?="",
    var longitude:String?="",
    var distance:String?=null
):Serializable