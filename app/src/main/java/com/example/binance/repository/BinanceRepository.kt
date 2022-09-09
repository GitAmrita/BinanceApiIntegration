package com.example.binance.repository

import com.example.binance.api.NetworkResult
import com.example.binance.model.Binance

interface BinanceRepository {
    suspend fun getBinanceList(): NetworkResult<List<Binance>?>
}