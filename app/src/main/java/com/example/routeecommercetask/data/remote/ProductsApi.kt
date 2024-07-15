package com.example.routeecommercetask.data.remote


import com.example.routeecommercetask.data.remote.dto.ProductResponse
import com.example.routeecommercetask.util.Resource
import retrofit2.Call
import retrofit2.http.GET

interface ProductsApi {
    @GET("products")
    fun getProducts() : Call<ProductResponse>
}