package com.richard.edvora.feature_homepage.presentation.homepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.richard.edvora.R
import com.richard.edvora.feature_homepage.domain.model.Product

@Composable
fun ProductItem(product : Product){
  Card(
      modifier = Modifier
          .height(150.dp)
          .width(210.dp)
          .background(colorResource(id = R.color.bgColor), RoundedCornerShape(5.dp)),
      elevation = 5.dp
  ){
      Column(
          modifier = Modifier
              .fillMaxWidth()
              .padding(16.dp)
      ) {

          Row(horizontalArrangement = Arrangement.SpaceBetween) {
              Column(Modifier.height(80.dp)) {

              }
          }
      }
  }
}