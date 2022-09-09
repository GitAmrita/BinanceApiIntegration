package com.example.binance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.binance.databinding.ItemBinding
import com.example.binance.model.Binance

class BinanceAdapter(val binanceList: List<Binance>): RecyclerView.Adapter<BinanceAdapter.BinanceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinanceViewHolder {
       val binding = ItemBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,
           false)
        return BinanceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BinanceViewHolder, position: Int) {
        holder.bind(binanceList[position])
    }

    override fun getItemCount(): Int {
        return binanceList.size
    }

    inner class BinanceViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(binance: Binance) {
            binding.symbol.text = binance.symbol
        }
    }
}