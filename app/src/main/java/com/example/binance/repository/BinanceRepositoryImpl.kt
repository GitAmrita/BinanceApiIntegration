package com.example.binance.repository

import com.example.binance.api.BinanceApi
import com.example.binance.api.NetworkResult
import com.example.binance.api.RetrofitClient
import com.example.binance.api.errorCodeHandler
import com.example.binance.model.Binance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BinanceRepositoryImpl: BinanceRepository {
     private val api = RetrofitClient.getRetrofit().create(BinanceApi::class.java)
    override suspend fun getBinanceList(): NetworkResult<List<Binance>?> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getBinanceList()
                if (response.isSuccessful) {
                    response.body()?.let {
                        NetworkResult.Success(data = it)
                    } ?: NetworkResult.Success(data = null)
                } else {
                    NetworkResult.Error(message = errorCodeHandler(response.code()))
                }

            } catch(e: Exception) {
                NetworkResult.Error(message = e.message)
            }
        }
    }
}