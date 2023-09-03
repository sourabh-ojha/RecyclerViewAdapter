package com.example.recyclerviewadapter

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewadapter.databinding.FirstScreenBinding
import com.example.recyclerviewadapter.model.Product
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: FirstScreenBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FirstScreenBinding.inflate(LayoutInflater.from(this@MainActivity))
        setContentView(binding.root)

        val productList = mutableListOf<Product>()
        repeat(10) {
            productList.add(
                Product(
                name = "Product #$it",
                description = "Some description about the product $it"
            )
            )
        }

        initAdapter(productList)
    }

    private fun initAdapter(list: List<Product>) {
        val productAdapter = ProductAdapter(list)
        binding.rvProduct.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvProduct.adapter = productAdapter
    }

}