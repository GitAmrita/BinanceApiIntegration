package com.example.binance.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binance.api.NetworkResult
import com.example.binance.model.Binance
import com.example.binance.repository.BinanceRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BinanceViewModel(private val repo: BinanceRepositoryImpl): ViewModel() {

    val binanceListLivedataObserver: LiveData<List<Binance>?>
    get() = binanceListMutableLiveData
    private var binanceListMutableLiveData =  MutableLiveData<List<Binance>?>()

    val binanceListLivedataErrorObserver: LiveData<String?>
    get() = binanceListMutableLivedataError
    private var binanceListMutableLivedataError = MutableLiveData<String?>()

    fun getBinanceList() {
        viewModelScope.launch(Dispatchers.Main) {
            when (val response = repo.getBinanceList()) {
                is NetworkResult.Success -> binanceListMutableLiveData.value = response.data
                is NetworkResult.Error -> binanceListMutableLivedataError.value = response.message
            }
        }
    }

    private fun contentProvider(): List<Binance> {
        val b = ArrayList<Binance>()
        b.add(Binance("ASD"))
        b.add(Binance("MKO"))
        b.add(Binance("VFT"))
        return b
    }
}