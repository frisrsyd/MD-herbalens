@file:Suppress("DEPRECATION")

package com.dicoding.md_herbalens.ui.lens

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.dicoding.md_herbalens.TensorFlowHelper
import com.dicoding.md_herbalens.TensorFlowHelper.imageSize
import com.dicoding.md_herbalens.ui.component.LensFab
import com.dicoding.md_herbalens.ui.navigation.Screen
import java.io.File
import java.util.concurrent.Executor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LensContent(
    modifier: Modifier,
    navController: NavHostController,
    outputDirectory: File,
    executor: Executor,
    onError: (ImageCaptureException) -> Unit,
    shouldShowCamera: Boolean
) {
    var photoUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var shouldShowCameraGlobal = shouldShowCamera
    val context = LocalContext.current
    var bitmap by remember {
        mutableStateOf<Bitmap?>(null)
    }
    var plantId = 0

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = {
            photoUri = it
        }
    )

    // 1
    val lensFacing = CameraSelector.LENS_FACING_BACK
    val currentContext = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val preview = Preview.Builder().build()
    val previewView = remember { PreviewView(context) }
    val imageCapture: ImageCapture = remember { ImageCapture.Builder().build() }
    val cameraSelector = CameraSelector.Builder()
        .requireLensFacing(lensFacing)
        .build()
    // 2
    LaunchedEffect(lensFacing) {
        val cameraProvider = currentContext.getCameraProvider()
        cameraProvider.unbindAll()
        cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector,
            preview,
            imageCapture
        )

        preview.setSurfaceProvider(previewView.surfaceProvider)
    }

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // 3
            if (shouldShowCameraGlobal) {
                AndroidView({ previewView }, modifier = Modifier.fillMaxSize())
            }
            photoUri?.let {
                if (Build.VERSION.SDK_INT < 28)
                    bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
                else {
                    val source = ImageDecoder.createSource(context.contentResolver, it)
                    bitmap = ImageDecoder.decodeBitmap(
                        source,
                        ImageDecoder.OnHeaderDecodedListener { decoder, info, source ->
                            decoder.allocator = ImageDecoder.ALLOCATOR_SOFTWARE
                            decoder.isMutableRequired = true
                        })
                }
            }


            bitmap?.let { it ->
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "Image from the gallery",
                    Modifier.size(400.dp)
                )
                Spacer(modifier = Modifier.padding(20.dp))

                val scaledBitmap = Bitmap.createScaledBitmap(it, imageSize, imageSize, false);
                TensorFlowHelper.classifyImage(scaledBitmap) {
                    plantId = it
                }
            }
            Spacer(modifier = Modifier.padding(20.dp))

        }
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        LensFab(modifier = modifier
            .padding(16.dp, 0.dp, 16.dp, 64.dp),
            onCLickGallery = {
                launcher.launch("image/*")
            },
            onCLickSearch = {
                navController.navigate(Screen.Detail.createRoute(plantId + 1))
            },
            onClickCamera = {
                Log.i("message", "ON CLICK")
                takePhoto(
                    filenameFormat = "yyyy-MM-dd-HH-mm-ss-SSS",
                    imageCapture = imageCapture,
                    outputDirectory = outputDirectory,
                    executor = executor,
                    onImageCaptured = {
                        Log.d("message", "IMAGE CAPTURED $it")
                        photoUri = it
                    },
                    onError = onError
                )
                shouldShowCameraGlobal = false
            }
        )
    }
}