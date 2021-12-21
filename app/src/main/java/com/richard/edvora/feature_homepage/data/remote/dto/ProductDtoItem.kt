package com.richard.edvora.feature_homepage.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.richard.edvora.feature_homepage.domain.model.Product
import java.text.DecimalFormat

data class ProductDtoItem(
    @SerializedName("address")
    val address: Address,
    @SerializedName("brand_name")
    val brandName: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("discription")
    val discription: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("time")
    val time: String
)

fun ProductDtoItem.toProduct() : Product{
    val decimalFormat = DecimalFormat("0.00")
    return Product(
        name = productName,
        brandName = brandName,
        price = decimalFormat.format(price.toDouble()),
        location = "${address.city} ${address.state}",
        date = date,
        img_url = image,
        description = discription,
        city = address.city,
        state = address.state
    )
}