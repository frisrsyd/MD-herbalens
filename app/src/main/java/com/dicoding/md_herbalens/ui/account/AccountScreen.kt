package com.dicoding.md_herbalens.ui.account

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    AccountContent(
        modifier = modifier,
        navController = navController
    )
}