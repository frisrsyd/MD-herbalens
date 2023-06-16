package com.dicoding.md_herbalens.ui.register

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.dicoding.md_herbalens.data.HerbalensAppViewModel
import com.dicoding.md_herbalens.factory.ViewModelFactory
import com.dicoding.md_herbalens.injection.RepositoryInjection

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: HerbalensAppViewModel = viewModel(
        factory = ViewModelFactory(RepositoryInjection.provideRepository())
    ),
) {
    RegisterContent(
        modifier = modifier,
        navController = navController,
        viewModel = viewModel
    )
}