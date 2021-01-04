package com.example.m2glide.network

import com.example.m2glide.data.ApiResponseWrapper
import retrofit2.http.GET

interface ApiService {
    @GET("/v1/search?query=nature&per_page=1")
    suspend fun fetchImages(): ApiResponseWrapper
}