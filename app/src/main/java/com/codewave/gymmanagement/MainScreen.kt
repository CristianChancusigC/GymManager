package com.codewave.gymmanagement

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.codewave.gymmanagement.appdata.DetailsScreen
import com.codewave.gymmanagement.appdata.Graph
import com.codewave.gymmanagement.appdata.HomeScreen
import com.codewave.gymmanagement.screensui.AboutMember
import com.codewave.gymmanagement.screensui.Analytics
import com.codewave.gymmanagement.screensui.History
import com.codewave.gymmanagement.screensui.Members
import com.codewave.gymmanagement.screensui.Register

@Composable
fun MainScreen(navHostController: NavHostController= rememberNavController()) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { MyBottomBarNavigation(navController) }
    ) { paddingValues ->
        NavHost(
            route = Graph.HOME,
            navController = navController,
            startDestination = HomeScreen.Register.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(HomeScreen.Register.route) { Register(navController) }
            composable(HomeScreen.Members.route) { Members() }
            composable(HomeScreen.History.route) { History() }
            composable(HomeScreen.Analytics.route) { Analytics() }
            detailNavGraph(navController)
        }
    }
}

@Composable
fun MyBottomBarNavigation(navController: NavController) {
    val screensUIMain =  listOf(
        HomeScreen.Register,
        HomeScreen.Members,
        HomeScreen.Analytics,
        HomeScreen.History
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = screensUIMain.any{it.route == currentDestination?.route}
    if (bottomBarDestination){
        NavigationBar {
            listOfNavItem.forEach { navItem ->
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any() { it.route == navItem.route } == true,
                    onClick = {
                        navController.navigate(navItem.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = { Icon(imageVector = navItem.icon, contentDescription = null) },
                    label = { Text(text = navItem.label) }
                )
            }
        }
    }
}

fun NavGraphBuilder.detailNavGraph(navController: NavHostController){
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.InfoMembers.route
    ){
        composable(route = DetailsScreen.InfoMembers.route){
            AboutMember(navController = navController)
        }
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}