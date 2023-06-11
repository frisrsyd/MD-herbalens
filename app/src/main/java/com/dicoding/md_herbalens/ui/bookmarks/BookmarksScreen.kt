package com.dicoding.md_herbalens.ui.bookmarks

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BookmarksScreen(
    modifier: Modifier = Modifier
) {
    BookmarksContent(
        modifier = modifier,
    )
}

@Composable
fun BookmarksContent(modifier: Modifier) {
    Text(text = "Bookmarks Screen")
}