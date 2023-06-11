package com.dicoding.md_herbalens.ui.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Detail: Screen("plant/{id}"){
        fun createRoute(id: Int) = "plant/$id"
    }
    object Profile: Screen("profile")
    object Recipe: Screen("recipe")
    object Lens: Screen("lens")
    object Bookmarks: Screen("bookmarks")
    object AllPlant: Screen("allplant")
}