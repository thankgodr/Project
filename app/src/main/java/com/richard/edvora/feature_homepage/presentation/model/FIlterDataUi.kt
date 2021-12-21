package com.richard.edvora.feature_homepage.presentation.model

data class FIlterDataUi(
    val name : String,
    val options : Set<String>,
    var value: String = ""
)
