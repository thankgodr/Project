package com.richard.edvora.feature_homepage.presentation.homepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.richard.edvora.R
import com.richard.edvora.feature_homepage.domain.model.Product
import com.skydoves.landscapist.glide.GlideImage

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

          Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
          ) {
             GlideImage(
                 imageModel = product.img_url,
                 
             )
              Column(Modifier.height(80.dp)) {
                  Text(
                      text = product.name,
                      style = MaterialTheme.typography.h4
                  )
                  Spacer(modifier = Modifier.height(3.dp))
                  Text(
                      text = product.brandName,
                      style = MaterialTheme.typography.h5
                  )
                  Spacer(modifier = Modifier.height(3.dp))
                  Text(
                      text = "$ ${product.price}",
                      style = MaterialTheme.typography.h5
                  )

              }
          }

          Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
          ) {
              Text(
                  text = product.location
              )
              Text(
                  text = "Date: ${product.date}"
              )
          }

          Text(
              text = product.description,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
          )
      }
  }
}