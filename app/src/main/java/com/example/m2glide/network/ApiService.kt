package com.example.m2glide.network

import com.example.m2glide.data.ApiResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

const val OAUTH_TOKEN = "563492ad6f917000010000016dacb63423d84c298dc77eca88b749f9"

interface ApiService {
    @Headers("Authorization: Bearer $OAUTH_TOKEN")
    @GET("/v1/search?per_page=40")
    suspend fun fetchImages(@Query("query") research: String): ApiResponseWrapper
}