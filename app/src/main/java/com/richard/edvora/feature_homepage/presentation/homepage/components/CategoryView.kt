package com.richard.edvora.feature_homepage.presentation.homepage.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.richard.edvora.feature_homepage.domain.model.Product
import com.richard.edvora.feature_homepage.domain.model.ProductCategory
import com.richard.edvora.feature_homepage.presentation.homepage.HomePageViewModel
import com.richard.edvora.ui.theme.backGroundDeep
import com.richard.edvora.ui.theme.cardColor
import com.richard.edvora.ui.theme.dividerColor

@Composable
fun CategoryView(category: List<ProductCategory>, viewModel: HomePageViewModel = hiltViewModel()){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 8.dp)
        ){
            FilterView()
            OutlinedButton(
                onClick = { viewModel.resetFilters() },
                Modifier.background(
                    cardColor, RoundedCornerShape(5.dp)
                ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = backGroundDeep,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Clear Filters"
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                .fillMaxSize()
        ){
            items(category){ currentCategory ->
                if(currentCategory.products.size > 0){
                    Column(Modifier.padding(end = 16.dp)) {
                        Text(
                            text =   currentCategory.categoryName,
                            style = MaterialTheme.typography.h6,
                        )
                        Divider(
                            modifier = Modifier.height(2.dp),
                            color = dividerColor)
                        Spacer(modifier = Modifier.height(2.dp))
                    }
                    Box(
                        modifier = Modifier
                            .border(0.dp, Color.Transparent)
                            .height(210.dp),
                        contentAlignment = Alignment.Center


                    ){

                        Column(
                            modifier = Modifier
                                .height(250.dp)
                                .padding(16.dp)
                                .background(shape = RoundedCornerShape(8.dp), color = cardColor)
                                .align(Alignment.Center),

                            ) {
                            Divider()
                        }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(180.dp),
                            backgroundColor = Color.Transparent

                        ) {
                            LazyRow(
                                modifier = Modifier
                                    .padding(
                                        top = 16.dp,
                                        bottom = 16.dp,
                                        start = 16.dp),
                                contentPadding = PaddingValues(start = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                items(currentCategory.products){ item: Product ->
                                    ProductItem(product = item)
                                }
                            }
                        }
                    }
                }

            }
        }
    }
    
}