package com.example.binance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.binance.databinding.ActivityMainBinding
import com.example.binance.repository.BinanceRepositoryImpl
import com.example.binance.viewModel.BinanceViewModel
import com.example.binance.viewModel.BinanceViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
//    private val viewModelFactory by lazy {
//        BinanceViewModelFactory()
//    }
    private val viewModel: BinanceViewModel by lazy {
        ViewModelProvider(this, BinanceViewModelFactory(
            BinanceRepositoryImpl()))[BinanceViewModel::class.java]
    }
    private val recyclerView: RecyclerView by lazy {
        binding.recycleView
    }
    private val clickMe: TextView by lazy {
        binding.clickMe
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initializeRecyclerView()
        setOnClickListener()
        setBinanceObserver()
        setBinanceErrorObserver()
    }

    private fun initializeRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setOnClickListener() {
        clickMe.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            viewModel.getBinanceList()
        }
    }

    private fun setBinanceObserver() {
        viewModel.binanceListLivedataObserver.observe(this) {
            it?.let {
                recyclerView.adapter = BinanceAdapter(it)
                recyclerView.adapter?.notifyDataSetChanged()
            }
        }
    }

    private fun setBinanceErrorObserver() {
        viewModel.binanceListLivedataErrorObserver.observe(this) {
            it?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}