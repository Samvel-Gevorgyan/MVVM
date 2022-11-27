package com.example.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.data.model.repository.NewsRepository

@Suppress("UNCHECKED_CAST")

class ViewModelFactory constructor(private val repository: NewsRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(NewsViewModel::class.java)){
            NewsViewModel( this.repository) as T
        }
        else{
            throw java.lang.IllegalArgumentException("ViewModel not found")
        }
    }
}