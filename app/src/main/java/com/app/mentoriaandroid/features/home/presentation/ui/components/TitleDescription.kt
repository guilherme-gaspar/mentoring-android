package com.app.mentoriaandroid.features.home.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleDescriptionComponent(
    title: String,
    description: String,
    fontSizeName: TextUnit = 16.sp,
    fontWeightName: FontWeight = FontWeight.Bold,
    fontSizeLastName: TextUnit = 12.sp,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 24.dp, start = 16.dp)
    ) {
        Text(
            text = title,
            fontSize = fontSizeName,
            fontWeight = fontWeightName,
        )

        Text(
            text = description,
            fontSize = fontSizeLastName,
            modifier = Modifier.padding(top = 8.dp)
        )

    }
}