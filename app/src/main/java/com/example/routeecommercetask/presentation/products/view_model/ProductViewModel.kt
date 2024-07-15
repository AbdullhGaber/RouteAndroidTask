package com.example.routeecommercetask.presentation.products.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routeecommercetask.data.models.Product
import com.example.routeecommercetask.data.remote.dto.ProductResponse
import com.example.routeecommercetask.domain.usecases.products.ProductsUseCases
import com.example.routeecommercetask.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productsUseCases: ProductsUseCases
) : ViewModel() {

    private val _productsStateFlow by lazy{
        MutableStateFlow<Resource<List<Product>>>(Resource.Unspecified())
    }

    val productStateFlow = _productsStateFlow.asStateFlow()

    init {
        getProducts()
    }

     private fun getProducts(){
        viewModelScope.launch(Dispatchers.IO) {
            _productsStateFlow.emit(Resource.Loading())
            delay(3000)
            productsUseCases.getProductsUseCase().enqueue(
                object : Callback<ProductResponse>{
                    override fun onResponse(
                        call: Call<ProductResponse>,
                        response: Response<ProductResponse>,
                    ){
                        if(response.body() != null){
                            val products = response.body()?.products
                            if(products != null){
                                onProductsSuccess(products)
                            }else{
                                onProductsFailure(Exception("Products is null"))
                                Log.e("Callback Error" , "Products is null")
                            }
                        }else{
                            onProductsFailure(Exception("Body is empty"))
                            Log.e("Callback Error" , "Body is empty")
                        }
                    }
                    override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                        onProductsFailure(t)
                        Log.e("Callback Error" , t.message.toString())
                    }
                }
            )
        }
    }

    private fun onProductsSuccess(products : List<Product>){
        viewModelScope.launch {
            _productsStateFlow.emit(Resource.Success(products))
        }
    }
    private fun onProductsFailure(th : Throwable){
        viewModelScope.launch{
            _productsStateFlow.emit(Resource.Failure(th.message))
        }
    }

}