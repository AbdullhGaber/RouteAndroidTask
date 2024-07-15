package com.example.routeecommercetask.domain.repositories

import com.example.routeecommercetask.data.remote.dto.ProductResponse
import com.example.routeecommercetask.util.Resource
import retrofit2.Call

interface ProductsRepository {
    fun getProducts() : Call<ProductResponse>
}