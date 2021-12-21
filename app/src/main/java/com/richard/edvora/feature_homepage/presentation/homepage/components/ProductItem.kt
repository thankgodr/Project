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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.richard.edvora.R
import com.richard.edvora.feature_homepage.domain.model.Product
import com.richard.edvora.feature_homepage.presentation.utils.DatePerser
import com.richard.edvora.ui.theme.backGroundDeep
import com.skydoves.landscapist.glide.GlideImage
/*
 Display single products
 */
@Composable
fun ProductItem(product : Product){
  Card(
      modifier = Modifier
          .height(140.dp)
          .width(220.dp)
          .padding(end = 16.dp)
          .background(backGroundDeep, RoundedCornerShape(5.dp)),
      elevation = 5.dp,
      backgroundColor = backGroundDeep
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
                 modifier = Modifier
                     .height(70.dp)
                     .width(70.dp),
                 imageModel = product.img_url,
                 
             )
              Column(
                  Modifier
                      .height(80.dp)
                      .fillMaxWidth()
                      .padding(start = 8.dp)) {
                  Text(
                      text = product.name,
                      style = MaterialTheme.typography.h4,
                      fontSize = 14.sp,
                      maxLines = 1,
                      lineHeight = 17.sp,
                      fontWeight = FontWeight.Bold
                  )
                  Spacer(modifier = Modifier.height(3.dp))
                  Text(
                      text = product.brandName,
                      style = MaterialTheme.typography.body2,
                      fontSize = 13.sp,
                  )
                  Spacer(modifier = Modifier.height(3.dp))
                  Text(
                      text = "$ ${product.price}",
                      style = MaterialTheme.typography.body2,
                      fontSize = 13.sp,
                  )

              }
          }

          Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween
          ) {
              Text(
                  text = product.location,
                  modifier = Modifier.width(60.dp),
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis,
                  style = MaterialTheme.typography.body2,
                  fontSize = 13.sp,

              )
              Text(
                  text = "Date: ${DatePerser.parseDate(product.date)}",
                  style = MaterialTheme.typography.body2,
                  fontSize = 13.sp,
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