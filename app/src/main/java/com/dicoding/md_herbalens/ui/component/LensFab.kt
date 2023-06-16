package com.dicoding.md_herbalens.ui.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.md_herbalens.R

@Composable
fun LensFab(
    modifier: Modifier = Modifier,
    onCLickGallery: () -> Unit,
    onCLickSearch: () -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
        FloatingActionButton(
            onClick = { onCLickSearch() },
            modifier = modifier
                .size(96.dp)
                .align(Alignment.BottomCenter),
            shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 28)),
            interactionSource = remember { MutableInteractionSource() },
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Cari Herbal",
                modifier = Modifier.size(36.dp)
            )
        }
        FloatingActionButton(
            onClick = { onCLickGallery() },
            modifier = modifier
                .align(Alignment.CenterStart),
            shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 12)),
            interactionSource = remember { MutableInteractionSource() },
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_image_24),
                contentDescription = "Pilih Gambar",
            )
        }
    }
}

@Preview
@Composable
fun LensFabPreview() {
    LensFab(
        modifier = Modifier,
        onCLickGallery = {},
        onCLickSearch = {}
    )
}