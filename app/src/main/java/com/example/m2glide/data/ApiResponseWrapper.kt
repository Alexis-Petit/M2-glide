package com.example.m2glide.data


data class ApiResponseWrapper(
    val photos: List<PhotoResponse>
)

data class PhotoResponse(
    val id: String,
    val url: String
)