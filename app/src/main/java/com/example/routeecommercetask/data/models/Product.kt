package com.example.routeecommercetask.data.models

data class Product(
    val id : Int,
    val title : String,
    val thumbnail : String,
    val rating : Float,
    val discountPercentage : Double,
    val price : Double,
    val oldPrice : Double
)
