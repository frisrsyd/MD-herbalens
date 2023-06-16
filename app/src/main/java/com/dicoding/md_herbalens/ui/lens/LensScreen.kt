package com.dicoding.md_herbalens.ui.lens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import java.io.File
import java.util.concurrent.ExecutorService

@Composable
fun LensScreen(
    modifier: Modifier = Modifier,
    requestPermission: () -> Unit,
    navController: NavHostController,
    shouldShowCamera: Boolean,
    outputDirectory: File,
    cameraExecutor: ExecutorService
) {
    requestPermission()
    LensContent(
        modifier = modifier,
        navController = navController,
        outputDirectory = outputDirectory,
        executor = cameraExecutor,
        onError = { Log.e("message", "View error:", it) },
        shouldShowCamera = shouldShowCamera
    )
}
