package com.richard.edvora.feature_homepage.presentation.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.richard.edvora.R
import com.richard.edvora.feature_homepage.presentation.homepage.components.CategoryView
import com.richard.edvora.ui.theme.whiteColor

@Composable
fun HomeScreen(viewModel: HomePageViewModel = hiltViewModel()){
    val loadingState = viewModel.productList.value
    val category = viewModel.categoryList.value
    Box(modifier = Modifier.fillMaxSize()) {

        if(!loadingState.isLoading){
            CategoryView(category = category)
        }
        if(loadingState.error.isNotBlank()) {
            Text(
                text = loadingState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(loadingState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = whiteColor
            )
        }
    }
}