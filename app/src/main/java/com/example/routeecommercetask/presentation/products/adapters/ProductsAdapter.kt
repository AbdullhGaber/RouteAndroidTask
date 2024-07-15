package com.example.routeecommercetask.presentation.products.adapters

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.routeecommercetask.data.models.Product
import com.example.routeecommercetask.databinding.ProductItemBinding


class ProductsAdapter : Adapter<ProductsAdapter.ProductsViewHolder>(){

    private val diffUtilCallBack = object : DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }

    val asyncListDiffer = AsyncListDiffer(this, diffUtilCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val mBinding = ProductItemBinding.inflate(inflater)
        return ProductsViewHolder(mBinding)
    }

    override fun getItemCount() = asyncListDiffer.currentList.size

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
            val product = asyncListDiffer.currentList[position]
            holder.bind(product)
    }

    inner class ProductsViewHolder(val mBinding : ProductItemBinding) : ViewHolder(mBinding.root){
        fun bind(product : Product){
            mBinding.productNameTv.text = product.title

            Glide.with(itemView).load(product.thumbnail).into(mBinding.productImageIv)

            val newPrice = String.format("%.2f", product.price - (product.price * product.discountPercentage / 100))
            mBinding.productPriceTv.text = "EGP $newPrice"

            mBinding.productOldPriceTv.apply{
                text = product.price.toString()
                paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }

            mBinding.reviewNoTv.text = "(${product.rating})"
        }
    }
}