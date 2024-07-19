package com.codewave.gymmanagement.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codewave.gymmanagement.MainScreen
import com.codewave.gymmanagement.appdata.Graph
import com.codewave.gymmanagement.screensui.Register

@Composable
fun RootNavigationGraph(navController: NavHostController) {
NavHost(
    navController = navController,
    startDestination = Graph.AUTHENTICATION,
    route = Graph.ROOT
) {
    authNavGraph(navController)
    composable(route = Graph.HOME){
        MainScreen()
    }
}
}