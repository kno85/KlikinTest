package com.example.klikintest

fun getMockedPlaceList(): List<Place> {
    val list= ArrayList<Place>()
    for(i in 1..10){
        list.add(
            Place(i,"Place "+i,
                "bla bla bla,bla bla bla,bla bla bla,bla bla bla,bla bla bla,bla bla bla",
                "")
        )
    }
    return list
}