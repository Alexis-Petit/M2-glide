package com.example.m2glide.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m2glide.R
import com.example.m2glide.databinding.PhotoBinding
import com.example.m2glide.domain.Photo

class PhotosAdapter(val photos: MutableList<Photo> = mutableListOf()) : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.photo,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    inner class PhotosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = PhotoBinding.bind(view)
        fun bind(photo: Photo) {
            Glide
                .with(binding.root.context)
                .load(photo.url)
                .into(binding.imageView)
        }
    }
}