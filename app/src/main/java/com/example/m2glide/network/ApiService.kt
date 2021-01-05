package com.example.m2glide.network

import com.example.m2glide.data.ApiResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Headers

const val OAUTH_TOKEN = "563492ad6f917000010000016dacb63423d84c298dc77eca88b749f9"

interface ApiService {
    @Headers("Authorization: Bearer $OAUTH_TOKEN")
    @GET("/v1/search?query=nature&per_page=40")
    suspend fun fetchImages(): ApiResponseWrapper
}