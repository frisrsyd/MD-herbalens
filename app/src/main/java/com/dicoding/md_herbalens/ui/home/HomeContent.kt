package com.dicoding.md_herbalens.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dicoding.md_herbalens.data.HerbalensAppViewModel
import com.dicoding.md_herbalens.model.PlantResponse
import com.dicoding.md_herbalens.ui.component.PlantListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    plants: PlantResponse?,
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit,
) {
    Box(modifier = modifier) {
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 32.dp, start = 16.dp, end = 16.dp),
        ) {
            item {
                if (plants != null) {
                    PlantListItem(
                        id = plants.plantId,
                        name = plants.plantName,
                        latin = plants.taxonomy.species,
                        image = plants.image,
                        modifier = Modifier
                            .clickable { navigateToDetail(plants.plantId) }
                    )
                }
            }
        }
    }
}