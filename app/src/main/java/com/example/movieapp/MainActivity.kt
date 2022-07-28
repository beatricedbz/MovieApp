package com.example.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: MovieAdapter
    lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        initViewModel()
    }

    private fun initRecycler() {
        adapter = MovieAdapter()
        binding.rvMovies.layoutManager = GridLayoutManager(this, 1)
        binding.rvMovies.adapter = adapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModel.getAllMovies()
        viewModel.recyclerListData.observe(this) {
            adapter.fillMovies(it.results)
        }
    }
}