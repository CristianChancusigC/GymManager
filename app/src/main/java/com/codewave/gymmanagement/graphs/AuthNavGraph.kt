package com.codewave.gymmanagement.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.codewave.gymmanagement.appdata.AuthScreen
import com.codewave.gymmanagement.appdata.Graph
import com.codewave.gymmanagement.screensui.Login

fun NavGraphBuilder.authNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            Login(navController = navController)
        }
    }
}