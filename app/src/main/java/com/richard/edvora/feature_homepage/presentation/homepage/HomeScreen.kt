package com.richard.edvora.feature_homepage.presentation.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.richard.edvora.R

@Composable
fun HomeScreen(viewModel: HomePageViewModel = hiltViewModel()){
    Column(
        Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.bgColor))) {



        
    }
}