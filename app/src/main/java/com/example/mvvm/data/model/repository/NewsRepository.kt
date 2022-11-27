package com.example.mvvm.data.model.repository

import com.example.mvvm.data.model.api.RetrofitService

class NewsRepository(private val retrofitService: RetrofitService?) {
   fun getNews()=retrofitService?.getNews()
}