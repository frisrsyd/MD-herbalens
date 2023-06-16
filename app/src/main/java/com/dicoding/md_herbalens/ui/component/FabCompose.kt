package com.dicoding.md_herbalens.ui.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.dicoding.md_herbalens.R

@Composable
fun FabCompose() {
    FloatingActionButton(
        interactionSource = remember { MutableInteractionSource() },
        shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
        contentColor = Color.Black,
        //elevation = FloatingActionButtonDefaults.elevation(),
        onClick = {

        }) {
        Icon(
            ImageVector.vectorResource(id = R.drawable.baseline_camera_24),
            contentDescription = "Camera"
        )
    }
}