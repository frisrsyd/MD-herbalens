package com.dicoding.md_herbalens.ui.receipe

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ReceipeScreen(
    modifier: Modifier = Modifier
) {
    ReceipeContent(
        modifier = modifier,
    )
}

@Composable
fun ReceipeContent(modifier: Modifier) {
    Text(text = "Receipe Screen")
}