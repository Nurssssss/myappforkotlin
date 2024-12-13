package com.example.slktap.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.slktap.R

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        viewModel.shopList.observe(this) { shopList ->
            Log.d("MainActivityTest", shopList.toString())
        }
        viewModel.getShopList()
    }
}
