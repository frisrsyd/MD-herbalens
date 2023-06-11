package com.dicoding.md_herbalens.ui.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    modifier: Modifier=Modifier
){
    HomeContent(
        modifier = modifier,
    )
}

@Composable
fun HomeContent(modifier: Modifier) {
    Text(text = "Home Screen")
}
