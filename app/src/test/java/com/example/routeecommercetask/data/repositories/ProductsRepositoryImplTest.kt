package com.example.routeecommercetask.data.repositories


import com.example.routeecommercetask.data.models.Product
import com.example.routeecommercetask.data.remote.ProductsApi
import com.example.routeecommercetask.data.remote.dto.ProductResponse
import com.example.routeecommercetask.domain.repositories.ProductsRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Call
import retrofit2.Response

class ProductsRepositoryImplTest {
lateinit var mProductsRepository : ProductsRepository
val mProductsProductsApi = mockk<ProductsApi>()
    @BeforeEach
    fun setUp() {
        mProductsRepository = ProductsRepositoryImpl(mProductsProductsApi)
    }

    @Test
    fun `verify that products data is retrieved from repository`() = runBlocking {
        val products = listOf(
            Product(),
            Product(),
            Product(),
            Product(),
            Product(),
        )
        // Create a mock response
        val mockResponse = mockk<Response<ProductResponse>>()
        val mockCall = mockk<Call<ProductResponse>>()

        // Mock the getProducts() method in ProductsApi to return mockCall
        coEvery { mProductsProductsApi.getProducts() } returns mockCall

        // Mock the execute() method in Call to return mockResponse
        coEvery { mockCall.execute() } returns mockResponse

        // Mock the response body and isSuccessful properties
        coEvery { mockResponse.isSuccessful } returns true
        coEvery { mockResponse.body() } returns ProductResponse(
            products = products
        )

        // Assertions
        Assertions.assertEquals(5 ,  products.size)
    }
}