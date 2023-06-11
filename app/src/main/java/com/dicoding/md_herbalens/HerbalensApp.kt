package com.dicoding.md_herbalens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dicoding.md_herbalens.ui.bookmarks.BookmarksScreen
import com.dicoding.md_herbalens.ui.component.BottomNavBar
import com.dicoding.md_herbalens.ui.explore.AllPlantScreen
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
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Detail.route) {
                BottomNavBar(navController = navController)
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

                )
            }
            composable(Screen.Bookmarks.route) {
                BookmarksScreen(

                )
            }
            composable(Screen.AllPlant.route) {
                AllPlantScreen(

                )
            }
        }
    }
}

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

@Preview(showBackground = true)
@Composable
fun HerbalensAppPreview() {
    MDherbalensTheme {
        HerbalensApp()
    }
}