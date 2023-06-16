package com.dicoding.md_herbalens.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    onNavigationIconClick: () -> Unit = {},
    onActionIconClick: () -> Unit = {},
    title: String,
    leftActionIcon: ImageVector? = null,
    rightActionIcon: ImageVector? = null,
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            if (leftActionIcon != null) {
                IconButton(onClick = onNavigationIconClick) {
                    Icon(leftActionIcon, contentDescription = "left action button")
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor =  MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        actions = {
            if (rightActionIcon != null) {
                IconButton(onClick = onActionIconClick) {
                    Icon(rightActionIcon, contentDescription = "right action button")
                }
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun NavigationBarPreview() {
    NavigationBar(title = "Detail")
}