package com.richard.edvora.feature_homepage.data.remote

import com.richard.edvora.feature_homepage.data.remote.dto.ProductDto
import retrofit2.http.GET

interface EdvoraApi {

    @GET("/")
    suspend fun getProducts() : ProductDto
}