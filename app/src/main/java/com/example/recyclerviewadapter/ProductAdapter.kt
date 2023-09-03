package com.example.recyclerviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewadapter.databinding.ListItemProductBinding
import com.example.recyclerviewadapter.model.Product

class ProductAdapter(private val dataList: List<Product>): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ListItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       holder.setData(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ProductViewHolder(private val binding: ListItemProductBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(data: Product) {
            binding.tvTitle.text = data.name
            binding.tvDesc.text = data.description
        }
    }
}