package com.dicoding.md_herbalens.ui.bookmarks

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dicoding.md_herbalens.data.HerbalensAppViewModel
import com.dicoding.md_herbalens.factory.ViewModelFactory
import com.dicoding.md_herbalens.injection.RepositoryInjection

@Composable
fun BookmarksScreen(
    modifier: Modifier = Modifier,
    viewModel: HerbalensAppViewModel = viewModel(
        factory = ViewModelFactory(RepositoryInjection.provideRepository())
    ),
    navigateToDetail: (Int) -> Unit
) {
    viewModel.getPlantById(2)
    val plants by viewModel.plantsById.collectAsState()
    BookmarksContent(
        plants = plants,
        viewModel = viewModel,
        navigateToDetail = navigateToDetail
    )
}