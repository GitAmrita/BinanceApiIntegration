package com.example.binance.api

import com.example.binance.model.Binance
import retrofit2.Response
import retrofit2.http.GET

interface BinanceApi {

    @GET("ticker/24hr")
    suspend fun getBinanceList(): Response<List<Binance>?>
}