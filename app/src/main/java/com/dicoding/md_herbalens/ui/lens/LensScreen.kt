package com.dicoding.md_herbalens.ui.lens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun LensScreen(
    modifier: Modifier = Modifier,
    requestPermission: () -> Unit,
    navController: NavHostController,
) {
    requestPermission()
    LensContent(
        modifier = modifier,
        navController = navController,
    )
}
