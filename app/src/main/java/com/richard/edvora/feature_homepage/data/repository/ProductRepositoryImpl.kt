package com.richard.edvora.feature_homepage.data.repository

import com.richard.edvora.feature_homepage.data.remote.EdvoraApi
import com.richard.edvora.feature_homepage.data.remote.dto.toProduct
import com.richard.edvora.feature_homepage.domain.model.Product
import com.richard.edvora.feature_homepage.domain.repisitory.ProductRepisotory
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api : EdvoraApi
) : ProductRepisotory {
    override suspend fun getProducts(): List<Product> {
        return api.getProducts().map {
            it.toProduct()
        }
    }
}