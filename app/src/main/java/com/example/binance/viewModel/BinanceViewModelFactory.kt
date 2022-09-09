package com.example.binance.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.binance.repository.BinanceRepositoryImpl

class BinanceViewModelFactory(private val repo: BinanceRepositoryImpl) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BinanceViewModel(repo) as T
    }
}
