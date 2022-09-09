package com.example.binance.model

import com.google.gson.annotations.SerializedName

data class Binance (
    @SerializedName("symbol")
    val symbol: String
 )
