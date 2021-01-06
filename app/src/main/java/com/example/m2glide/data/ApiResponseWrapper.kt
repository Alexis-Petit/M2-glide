package com.example.m2glide.data

data class ApiResponseWrapper(
    val photos: List<PhotoResponse>
)

data class PhotoResponse(
    val id: String,
    val url: String,
    val photographer: String,
    val src: Src
)

data class Src(
    val portrait: String
)


