package com.dicoding.md_herbalens.ui.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.dicoding.md_herbalens.data.HerbalensAppViewModel
import com.dicoding.md_herbalens.factory.ViewModelFactory
import com.dicoding.md_herbalens.injection.RepositoryInjection

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: HerbalensAppViewModel = viewModel(
        factory = ViewModelFactory(RepositoryInjection.provideRepository())
    ),
) {

    LoginContent(
        modifier = modifier,
        navController = navController,
        viewModel = viewModel
    )
}