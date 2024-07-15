package com.example.routeecommercetask.data.models

data class Product(
    val id : Int = 1,
    val title : String = "default title",
    val thumbnail : String = "thumb",
    val rating : Float = 0.0f,
    val discountPercentage : Double = 0.0,
    val price : Double = 0.0,
    val oldPrice : Double = 0.0
)
