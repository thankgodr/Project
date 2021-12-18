package com.richard.edvora.feature_homepage.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String
)