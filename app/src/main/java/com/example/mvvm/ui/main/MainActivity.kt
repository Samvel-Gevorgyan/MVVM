package com.example.mvvm.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.data.model.api.RetrofitService
import com.example.mvvm.data.model.repository.NewsRepository
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.ui.main.adapter.NewsAdapter
import com.example.mvvm.viewmodel.NewsViewModel
import com.example.mvvm.viewmodel.ViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NewsViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val adapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(
                this,
                ViewModelFactory(NewsRepository(retrofitService))
            )[NewsViewModel::class.java]
        binding.recyclerView.adapter = adapter

        viewModel.liveData.observe(this) {
            adapter.updateData(it?.response?.results?.toList())
        }
    }

}
