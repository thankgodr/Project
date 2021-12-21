package com.richard.edvora.feature_homepage.domain.model

data class  Product(
    val name : String = "",
    val brandName : String = "",
    val price  : Double = 0.00,
    val location : String = "",
    val date : String = "",
    val description : String = "",
    val img_url : String = "",
    val city : String = "",
    val state : String = ""
)