package com.example.routeecommercetask.data.remote.dto

import com.example.routeecommercetask.data.models.Product
import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("products")
    val products: List<Product>? = null,
    @SerializedName("total")
    val total: Int? = null,
    @SerializedName("skip")
    val skip: Int? = null,
    @SerializedName("limit")
    val limit:Int? = null
)
