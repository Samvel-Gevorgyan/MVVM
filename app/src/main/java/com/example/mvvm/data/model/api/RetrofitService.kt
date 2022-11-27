package com.example.mvvm.data.model.api

import com.example.mvvm.data.model.GuardianNewsData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("search")
    fun getNews(@Query("api-key") apiKey: String = API_KEY): Call<GuardianNewsData>

    companion object {

        const val BASE_URL="https://content.guardianapis.com/"
        const val API_KEY= "086680c6-53f9-4216-a0b3-0097d1dc2376"

        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService? {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService
        }
    }
}