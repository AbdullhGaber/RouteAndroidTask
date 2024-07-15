package com.example.routeecommercetask.presentation.products.ui.activities

import com.example.routeecommercetask.util.SpaceItemDecoration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View

import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.routeecommercetask.R
import com.example.routeecommercetask.databinding.ActivityProductsBinding
import com.example.routeecommercetask.presentation.products.adapters.ProductsAdapter
import com.example.routeecommercetask.presentation.products.view_model.ProductViewModel
import com.example.routeecommercetask.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {
    private val mProductsViewModel by viewModels<ProductViewModel>()
    private val mProductsAdapter by lazy {
        ProductsAdapter()
    }
    private lateinit var mBinding : ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { true }
        lifecycleScope.launch {
            delay(3000) // 3 seconds delay to show the splash screen
        }
        splashScreen.setKeepOnScreenCondition{false}
        enableEdgeToEdge()
        mBinding = ActivityProductsBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setProductsRV()
        observeOnProducts()
    }

    private fun setProductsRV(){
        mBinding.productsRv.apply {
            adapter = mProductsAdapter
            layoutManager = GridLayoutManager(this@ProductsActivity , 2, LinearLayoutManager.VERTICAL , false)
            addItemDecoration(SpaceItemDecoration(resources.getDimensionPixelSize(R.dimen.space_item_decoration),2,true))
        }
    }

    private fun observeOnProducts(){
        lifecycleScope.launch {
            mProductsViewModel.productStateFlow.collect{
               when(it){
                   is Resource.Loading -> {
                       mBinding.productsRv.visibility = View.GONE
                        mBinding.shimmerLayout.startShimmer()
                   }

                   is Resource.Success -> {
                       mBinding.shimmerLayout.stopShimmer()
                       mBinding.shimmerLayout.setShimmer(null)
                       mBinding.productsRv.visibility = View.VISIBLE
                       mBinding.shimmerLayout.visibility = View.GONE
                       mProductsAdapter.asyncListDiffer.submitList(it.data)
                   }

                   is Resource.Failure -> {
                       Log.e("Resource Error" , it.message.toString())
                   }

                   else -> Unit

               }
            }
        }
    }

}