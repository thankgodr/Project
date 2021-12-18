package com.richard.edvora.feature_homepage.presentation.homepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.richard.edvora.feature_homepage.domain.model.Product
import com.richard.edvora.feature_homepage.domain.model.ProductCategory

@Composable
fun CategoryView(category: List<ProductCategory>){
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ){
        items(category){ currentCategory ->
            Text(
                text =   currentCategory.categoryName,
                style = MaterialTheme.typography.h3
            )
            Divider(Modifier.height(2.dp))

            Card(
                backgroundColor = Color.Black,
                modifier = Modifier
                    .background(Color.Black, RoundedCornerShape(5.dp) )
            ) {
                LazyRow{
                    items(currentCategory.products){ item: Product ->  
                        ProductItem(product = item)
                    }
                }
            }
        }
    }
}