package com.example.routeecommercetask.data.repositories

import com.example.routeecommercetask.data.remote.ProductsApi
import com.example.routeecommercetask.data.remote.dto.ProductResponse
import com.example.routeecommercetask.domain.repositories.ProductsRepository
import com.example.routeecommercetask.util.Resource
import retrofit2.Call

class ProductsRepositoryImpl(
    private val productsApi: ProductsApi
) : ProductsRepository {
    override fun getProducts() : Call<ProductResponse>{
        return productsApi.getProducts()
    }
}