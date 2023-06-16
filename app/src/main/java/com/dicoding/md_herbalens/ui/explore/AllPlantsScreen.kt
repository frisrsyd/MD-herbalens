package com.dicoding.md_herbalens.ui.explore

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dicoding.md_herbalens.data.HerbalensAppViewModel
import com.dicoding.md_herbalens.factory.ViewModelFactory
import com.dicoding.md_herbalens.injection.RepositoryInjection

@Composable
fun AllPlantsScreen(
    viewModel: HerbalensAppViewModel = viewModel(
        factory = ViewModelFactory(RepositoryInjection.provideRepository())
    ),
    navigateToDetail:(Int)-> Unit
) {
    viewModel.getAllPlants()
    val plants by viewModel.plantsByName.collectAsState()
    plants?.let {
        AllPlantsContent(
            plants = it,
            viewModel = viewModel,
            navigateToDetail = navigateToDetail
        )
    }

}
