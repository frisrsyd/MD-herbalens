package com.dicoding.md_herbalens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dicoding.md_herbalens.ui.account.AccountScreen
import com.dicoding.md_herbalens.ui.bookmarks.BookmarksScreen
import com.dicoding.md_herbalens.ui.component.BottomNavBar
import com.dicoding.md_herbalens.ui.component.NavigationBar
import com.dicoding.md_herbalens.ui.details.DetailScreen
import com.dicoding.md_herbalens.ui.explore.AllPlantsScreen
import com.dicoding.md_herbalens.ui.home.HomeScreen
import com.dicoding.md_herbalens.ui.lens.LensScreen
import com.dicoding.md_herbalens.ui.login.LoginScreen
import com.dicoding.md_herbalens.ui.navigation.Screen
import com.dicoding.md_herbalens.ui.register.RegisterScreen
import java.io.File
import java.util.concurrent.ExecutorService

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HerbalensApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    requestPermission: () -> Unit,
    shouldShowCamera: Boolean,
    outputDirectory: File,
    cameraExecutor: ExecutorService
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Detail.route && currentRoute != Screen.Lens.route) {
                BottomNavBar(navController = navController)
            }
        },
        topBar = {
            val onNavigationIconClick: () -> Unit = {
                navController.popBackStack()
            }
            val onActionIconClick: () -> Unit = {
                navController.navigate(Screen.Account.route)
            }
            when (currentRoute) {
                Screen.Lens.route -> NavigationBar(
                    leftActionIcon = Icons.Default.ArrowBack,
                    rightActionIcon = null,
                    title = "HerbaScan",
                    onNavigationIconClick = { onNavigationIconClick() }
                )

                Screen.Detail.route -> NavigationBar(
                    leftActionIcon = Icons.Default.ArrowBack,
                    rightActionIcon = ImageVector.vectorResource(id = R.drawable.baseline_bookmark_border_24),
                    title = "Detail",
                    onNavigationIconClick = { onNavigationIconClick() },
                    onActionIconClick = {

                    }

                )

                Screen.Home.route -> NavigationBar(
                    leftActionIcon = null,
                    rightActionIcon = Icons.Default.AccountCircle,
                    title = "Herbalens",
                    onActionIconClick = { onActionIconClick() }
                )

                Screen.Bookmarks.route -> NavigationBar(
                    leftActionIcon = null,
                    rightActionIcon = Icons.Default.AccountCircle,
                    title = "Disimpan",
                    onActionIconClick = { onActionIconClick() }
                )

                Screen.AllPlant.route -> NavigationBar(
                    leftActionIcon = null,
                    rightActionIcon = Icons.Default.AccountCircle,
                    title = "Semua Tanaman",
                    onActionIconClick = { onActionIconClick() }
                )

                Screen.Account.route -> NavigationBar(
                    leftActionIcon = Icons.Default.ArrowBack,
                    rightActionIcon = null,
                    title = "Akun",
                    onNavigationIconClick = { onNavigationIconClick() }
                )

                Screen.Register.route -> NavigationBar(
                    leftActionIcon = Icons.Default.ArrowBack,
                    rightActionIcon = null,
                    title = "Daftar",
                    onNavigationIconClick = { onNavigationIconClick() }
                )

                Screen.Login.route -> NavigationBar(
                    leftActionIcon = Icons.Default.ArrowBack,
                    rightActionIcon = null,
                    title = "Masuk",
                    onNavigationIconClick = { onNavigationIconClick() }
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { plantId ->
                        navController.navigate(
                            Screen.Detail.createRoute(plantId)
                        )
                    },
                )
            }
            composable(Screen.Lens.route) {
                LensScreen(
                    requestPermission = requestPermission,
                    navController = navController,
                    shouldShowCamera = shouldShowCamera,
                    outputDirectory = outputDirectory,
                    cameraExecutor = cameraExecutor
                )
            }
            composable(Screen.Bookmarks.route) {
                BookmarksScreen(
                    navigateToDetail = { plantId ->
                        navController.navigate(
                            Screen.Detail.createRoute(plantId)
                        )
                    }
                )
            }
            composable(Screen.AllPlant.route) {
                AllPlantsScreen(
                    navigateToDetail = { plantId ->
                        navController.navigate(
                            Screen.Detail.createRoute(plantId)
                        )
                    }
                )
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("id") {
                    type = NavType.IntType
                })
            ) {
                val receivedPlantId = it.arguments!!.getInt("id")
                DetailScreen(
                    plantId = receivedPlantId,
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
            composable(Screen.Register.route) {
                RegisterScreen(
                    navController = navController,
                )
            }
            composable(Screen.Login.route) {
                LoginScreen(
                    navController = navController,
                )
            }
            composable(Screen.Account.route) {
                AccountScreen(
                    navController = navController,
                )
            }
        }
    }
}
