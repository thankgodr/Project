package com.richard.edvora.feature_homepage.presentation.homepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.richard.edvora.feature_homepage.presentation.model.FIlterDataUi
import com.richard.edvora.ui.theme.backGroundDeep

@Composable
fun SingleFilter(fIlterDataUi: FIlterDataUi, complete : (String, Boolean) -> Unit){
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(fIlterDataUi.name) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.ArrowDropDown


   Column() {
       OutlinedTextField(
           value = selectedText,
           enabled = false,
           onValueChange = { selectedText = it },
           textStyle = TextStyle(
               color = Color.White,
               fontSize = 16.sp
           ),
           modifier = Modifier
               .wrapContentWidth()
               .height(65.dp)
               .padding(7.dp)
               .clickable {
                   expanded = !expanded
               }
               .border(1.dp, Color.White, RoundedCornerShape(5.dp)),
           trailingIcon = {
               Icon(
                   icon,
                   "contentDescription",
                   Modifier.clickable { expanded = !expanded },
                   tint = Color.White
               )

           },



           )

       DropdownMenu(
           expanded = expanded,
           onDismissRequest = { expanded = false },
           modifier = Modifier
               .wrapContentWidth()
               .background(backGroundDeep),



           ) {
           Column(
               Modifier.padding(16.dp)
           ) {
               fIlterDataUi.options.forEach { label ->
                   DropdownMenuItem(onClick = {
                       selectedText = label
                       expanded = !expanded
                       complete(selectedText, expanded)
                   }) {
                       Text(
                           text = label,
                           color = Color.White
                       )
                   }
               }

           }
       }
   }
}