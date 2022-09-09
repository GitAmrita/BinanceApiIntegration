package com.example.binance.api

fun errorCodeHandler(errorCode: Int): String {
    return when (errorCode) {
        in 400..499 -> "Bad request, client error"
        in 500..599 -> "Server error, come back later"
        in 300..399 -> "Removed"
        else -> "Generic error"
    }
}