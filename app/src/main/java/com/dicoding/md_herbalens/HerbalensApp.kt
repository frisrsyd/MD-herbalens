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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dicoding.md_herbalens.ui.bookmarks.BookmarksScreen
import com.dicoding.md_herbalens.ui.component.BottomNavBar
import com.dicoding.md_herbalens.ui.component.NavigationBar
import com.dicoding.md_herbalens.ui.details.DetailScreen
import com.dicoding.md_herbalens.ui.explore.AllPlantsScreen
import com.dicoding.md_herbalens.ui.home.HomeScreen
import com.dicoding.md_herbalens.ui.lens.LensScreen
import com.dicoding.md_herbalens.ui.navigation.Screen
import com.dicoding.md_herbalens.ui.receipe.ReceipeScreen
import com.dicoding.md_herbalens.ui.theme.MDherbalensTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HerbalensApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    requestPermission: () -> Unit,
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
            if (currentRoute == Screen.Lens.route || currentRoute == Screen.Detail.route) {
                NavigationBar(
                    leftActionIcon = Icons.Default.ArrowBack,
                    rightActionIcon = Icons.Default.AccountCircle,
                    title = if (currentRoute == Screen.Lens.route) "Lens" else "Detail",
                    onNavigationIconClick = { onNavigationIconClick()}
                )
            }
            when(currentRoute) {
                Screen.Home.route -> NavigationBar(
                    leftActionIcon = null,
                    rightActionIcon = Icons.Default.AccountCircle,
                    title = "Home",
                )
                Screen.Recipe.route -> NavigationBar(
                    leftActionIcon = null,
                    rightActionIcon = Icons.Default.AccountCircle,
                    title = "Recipe",
                )
                Screen.Bookmarks.route -> NavigationBar(
                    leftActionIcon = null,
                    rightActionIcon = Icons.Default.AccountCircle,
                    title = "Bookmarks",
                )
                Screen.AllPlant.route -> NavigationBar(
                    leftActionIcon = null,
                    rightActionIcon = Icons.Default.AccountCircle,
                    title = "All Plants",
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

                )
            }
            composable(Screen.Recipe.route) {
                ReceipeScreen(

                )
            }
            composable(Screen.Lens.route) {
                LensScreen(
                    requestPermission = requestPermission
                )
            }
            composable(Screen.Bookmarks.route) {
                BookmarksScreen(

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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HerbalensAppPreview() {
    MDherbalensTheme {
        HerbalensApp(
            requestPermission = { }
        )
    }
}