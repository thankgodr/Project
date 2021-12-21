package com.richard.edvora.feature_homepage.presentation.utils

import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

object DatePerser {

    fun parseDate(date : String): String {
        "2013-03-06T18:13:54.150Z"
        val stringARr = date.split("-")
        val year = stringARr[0]
        val dayArray = stringARr[2].split("")
        val day = "${dayArray[1]}${dayArray[2]}"
        val month = stringARr[1];
        return "${month}:${day}:${year}"
    }
}