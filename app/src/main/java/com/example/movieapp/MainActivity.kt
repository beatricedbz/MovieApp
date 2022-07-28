package com.example.movieapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: MovieAdapter
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        observeMovies()
    }

    private fun initRecycler() {
        adapter = MovieAdapter()
        binding.rvMovies.layoutManager = GridLayoutManager(this, 1)
        binding.rvMovies.adapter = adapter
    }

    private fun observeMovies() {
        viewModel.recyclerListData.observe(this) {
            adapter.fillMovies(it.results)
        }
    }
}