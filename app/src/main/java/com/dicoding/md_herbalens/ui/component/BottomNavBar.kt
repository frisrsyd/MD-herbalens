package com.dicoding.md_herbalens.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dicoding.md_herbalens.R
import com.dicoding.md_herbalens.ui.navigation.NavigationItem
import com.dicoding.md_herbalens.ui.navigation.Screen

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    BottomAppBar(modifier = modifier) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItem = listOf(
            NavigationItem(
                icon = Icons.Default.Home,
                screen = Screen.Home,
                title = stringResource(R.string.beranda)
            ),
            NavigationItem(
                icon = ImageVector.vectorResource(id = R.drawable.baseline_receipt_long_24),
                screen = Screen.Recipe,
                title = stringResource(R.string.resep)
            ),
            NavigationItem(
                icon = ImageVector.vectorResource(id = R.drawable.baseline_camera_24),
                screen = Screen.Lens,
                title = stringResource(R.string.lens)
            ),
            NavigationItem(
                icon = ImageVector.vectorResource(id = R.drawable.baseline_book_24),
                screen = Screen.Bookmarks,
                title = stringResource(R.string.disimpan)
            ),
            NavigationItem(
                icon = ImageVector.vectorResource(id = R.drawable.baseline_explore_24),
                screen = Screen.AllPlant,
                title = stringResource(R.string.jelajahi)
            ),
        )

        BottomAppBar {
            navigationItem.map { menuItem ->
                NavigationBarItem(
                    selected = currentRoute == menuItem.screen.route,
                    onClick = {
                        navController.navigate(menuItem.screen.route) {
                            popUpTo(
                                navController.graph.findStartDestination().id
                            ) {
                                saveState = true
                            }

                            restoreState = true
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = menuItem.icon,
                            contentDescription = menuItem.title,
                        )
                    },
                    label = {
                        Text(
                            text = menuItem.title
                        )
                    }
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    BottomNavBar(navController = NavHostController(LocalContext.current))
}