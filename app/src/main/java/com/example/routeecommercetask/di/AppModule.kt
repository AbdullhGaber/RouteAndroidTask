package com.example.routeecommercetask.di

import com.example.routeecommercetask.data.remote.ProductsApi
import com.example.routeecommercetask.data.repositories.ProductsRepositoryImpl
import com.example.routeecommercetask.domain.repositories.ProductsRepository
import com.example.routeecommercetask.domain.usecases.products.GetProductsUseCase
import com.example.routeecommercetask.domain.usecases.products.ProductsUseCases
import com.example.routeecommercetask.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideProductsApi() : ProductsApi {
        return Retrofit.Builder().
        baseUrl(Constants.BASE_URL).
        addConverterFactory(GsonConverterFactory.create()).
        build().
        create(ProductsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsRepository(
        productsApi: ProductsApi
    ) : ProductsRepository{
        return ProductsRepositoryImpl(productsApi)
    }

    @Provides
    @Singleton
    fun provideProductsUseCase(productsRepository: ProductsRepository) : ProductsUseCases{
        return ProductsUseCases(
            getProductsUseCase = GetProductsUseCase(productsRepository)
        )
    }
}