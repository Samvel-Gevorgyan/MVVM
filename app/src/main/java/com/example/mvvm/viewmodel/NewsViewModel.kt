package com.example.mvvm.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.data.model.GuardianNewsData
import com.example.mvvm.data.model.repository.NewsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel constructor(private var repository: NewsRepository) : ViewModel() {

    private var newsLiveData = MutableLiveData<GuardianNewsData>()
    val liveData: LiveData<GuardianNewsData> = newsLiveData


    private fun getNews() {
        val response = repository.getNews()

        response?.enqueue(object : Callback<GuardianNewsData> {
            @SuppressLint("LongLogTag")

            override fun onResponse(call: Call<GuardianNewsData>, response: Response<GuardianNewsData>) {

                Log.d("GuardianNews-onResponse:", "response:${response.body().toString()}")
                if (response.isSuccessful) {
                    newsLiveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<GuardianNewsData>, t: Throwable) {
                Log.d(
                    "GuardianNews-onFailure:",
                    "Throwable:${t.message.toString()} or errorResponse:${call.request().body} and request url ${call.request().url}"
                )
            }
        })
    }

    init {
        getNews()
    }
}