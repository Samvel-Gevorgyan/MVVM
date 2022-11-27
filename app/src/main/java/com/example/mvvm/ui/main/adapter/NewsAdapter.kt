package com.example.mvvm.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.data.model.GuardianNewsResult
import com.example.mvvm.databinding.AdapterBinding




class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var items:MutableList<GuardianNewsResult> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = AdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<GuardianNewsResult>?){
        this.items.clear()
       items?.let { this.items.addAll(it) }
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(private var binding: AdapterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GuardianNewsResult) {
            binding.textId.text = item.id
            binding.textType.text = item.type
            binding.textSecondId.text = item.sectionId
        }
    }

}