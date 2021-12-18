package com.richard.edvora.feature_homepage.presentation.homepage

import com.richard.edvora.feature_homepage.domain.model.Product

data class ProductListState(
    val isLoading: Boolean = false,
    val coins: List<Product> = emptyList(),
    val error: String = ""
)