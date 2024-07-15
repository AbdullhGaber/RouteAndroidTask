package com.example.routeecommercetask.domain.usecases.products

import com.example.routeecommercetask.data.remote.dto.ProductResponse
import com.example.routeecommercetask.domain.repositories.ProductsRepository
import com.example.routeecommercetask.util.Resource
import retrofit2.Call

class GetProductsUseCase(
    private val productsRepository: ProductsRepository
) {
     operator fun invoke() : Call<ProductResponse> {
        return productsRepository.getProducts()
    }
}