package com.codewave.gymmanagement.appdata

object Graph{
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "Details_graph"
}

sealed class AuthScreen(val route: String){
    data object Login:AuthScreen(route = "Login")
}

sealed class HomeScreen(val route: String){
    data object Register:HomeScreen(route = "register")
    data object Members:HomeScreen(route = "members")
    data object History:HomeScreen(route = "history")
    data object Analytics:HomeScreen(route = "analytics")
}

sealed class DetailsScreen(val route: String){
    data object InfoMembers:DetailsScreen(route = "about")
}