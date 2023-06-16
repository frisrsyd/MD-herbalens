package com.dicoding.md_herbalens.ui.lens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun LensScreen(
    modifier: Modifier = Modifier,
    requestPermission: () -> Unit,
    navigateToDetail: (Int) -> Unit,
) {
    requestPermission()
    LensContent(
        modifier = modifier,
        navigateToDetail = navigateToDetail
    )
}
