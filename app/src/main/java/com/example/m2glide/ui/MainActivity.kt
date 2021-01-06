package com.example.m2glide.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m2glide.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private val photosAdapter = PhotosAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.photosRecyclerView.adapter = photosAdapter
        val linearManager = LinearLayoutManager(this)
        binding.photosRecyclerView.layoutManager = linearManager
        mainViewModel.photosLiveData.observe(this,
            Observer { list ->
                with(photosAdapter) {
                    photos.clear()
                    photos.addAll(list)
                    notifyDataSetChanged()
                }
            }
        )
    }
}