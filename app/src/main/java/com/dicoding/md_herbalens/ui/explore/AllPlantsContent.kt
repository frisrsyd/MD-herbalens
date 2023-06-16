package com.dicoding.md_herbalens.ui.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dicoding.md_herbalens.data.HerbalensAppViewModel
import com.dicoding.md_herbalens.model.PlantResponse
import com.dicoding.md_herbalens.ui.component.PlantListItem
import com.dicoding.md_herbalens.ui.component.SearchBar

@Composable
fun AllPlantsContent(
    plants: List<PlantResponse>,
    modifier: Modifier = Modifier,
    viewModel: HerbalensAppViewModel,
    navigateToDetail: (Int) -> Unit
) {
    Box(modifier = modifier) {
        val query by viewModel.query
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 32.dp),
        ) {
            item {
                SearchBar(
                    query = query,
                    onQueryChange = viewModel::search,
                    modifier = Modifier.background(MaterialTheme.colorScheme.tertiary)
                )
            }
            item {
                Spacer(modifier = Modifier.height(12.dp))
            }
            items(plants) { item ->

                Spacer(modifier = Modifier.height(16.dp))

                PlantListItem(
                    id = item.plantId,
                    name = item.plantName,
                    latin = item.taxonomy.species,
                    image = item.image,
                    modifier = Modifier
                        .clickable { navigateToDetail(item.plantId) }
                )
            }
        }
    }
}
