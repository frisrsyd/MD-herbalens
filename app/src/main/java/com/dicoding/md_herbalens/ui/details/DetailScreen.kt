package com.dicoding.md_herbalens.ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dicoding.md_herbalens.data.HerbalensAppViewModel
import com.dicoding.md_herbalens.factory.ViewModelFactory
import com.dicoding.md_herbalens.injection.RepositoryInjection
import com.dicoding.md_herbalens.ui.explore.AllPlantsContent

@Composable
fun DetailScreen(
    plantId: Int,
    viewModel: HerbalensAppViewModel = viewModel(
        factory = ViewModelFactory(
            RepositoryInjection.provideRepository()
        )
    ),
    navigateBack: () -> Unit
) {
    viewModel.getPlantById(plantId)
    val plants by viewModel.plantsById.collectAsState()
    plants?.let {
        val modifier = androidx.compose.ui.Modifier
        DetailContent(
            modifier = modifier,
            title = it.plantName,
            description = it.description,
            image = it.image,
            benefits = it.benefit,
            recipes = it.recipes,
            onBackClick = navigateBack
        )
    }

}