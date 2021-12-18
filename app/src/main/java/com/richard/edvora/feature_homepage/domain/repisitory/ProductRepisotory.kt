package com.richard.edvora.feature_homepage.domain.repisitory

import com.richard.edvora.feature_homepage.domain.model.Product

interface ProductRepisotory {
    suspend fun getProducts() : List<Product>

}