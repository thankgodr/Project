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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.richard.edvora.feature_homepage.presentation.homepage.HomePageViewModel
import com.richard.edvora.feature_homepage.presentation.model.FIlterDataUi
import com.richard.edvora.ui.theme.cardColor
import com.richard.edvora.ui.theme.whiteColor

@Composable
fun FilterView(viewModel : HomePageViewModel = hiltViewModel()) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Filter") }

    val productsName = viewModel.productNameList.value
    val statesName = viewModel.stateList.value
    val cityNames = viewModel.cityList.value
    
    val filteroptionsData = listOf(
        FIlterDataUi("Product", productsName),
        FIlterDataUi("State", statesName),
        FIlterDataUi("City", cityNames)
    )

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
    Icons.Filled.ArrowDropDown


    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = selectedText,
            enabled = false,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
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
                .width(230.dp)
                .background(cardColor),



        ) {
            Column(
                Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Filter",
                    color = Color(0xFFA5A5A5),
                )
                Divider(
                    modifier = Modifier
                        .height(2.dp),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                filteroptionsData.forEach { label ->
                    DropdownMenuItem(onClick = {
                        
                    }) {
                        SingleFilter(fIlterDataUi = label, { valueSelected, status ->
                             label.value = valueSelected
                             expanded = status
                             viewModel.doFilter(label)
                        })
                    }
                }

            }
        }
    }
}