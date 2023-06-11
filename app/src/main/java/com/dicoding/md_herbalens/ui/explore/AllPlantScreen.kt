package com.dicoding.md_herbalens.ui.explore

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AllPlantScreen(
    modifier: Modifier = Modifier
) {
    AllPlantContent(
        modifier = modifier,
    )
}

@Composable
fun AllPlantContent(modifier: Modifier) {
    Text(text = "Receipe Screen")
}