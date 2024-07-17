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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.codewave.gymmanagement.appdata.Screens
import com.codewave.gymmanagement.screensui.AboutMember
import com.codewave.gymmanagement.screensui.Analytics
import com.codewave.gymmanagement.screensui.History
import com.codewave.gymmanagement.screensui.Members
import com.codewave.gymmanagement.screensui.Register

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { MyBottomBarNavigation(navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.RegisterScreen.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            //detailsNavGraph(navHostController = navController)
            composable(Screens.RegisterScreen.name) { Register(navController) }
            composable(Screens.MembersScreens.name) { Members() }
            composable(Screens.HistoryScreens.name) { History() }
            composable(Screens.AnalyticsScreens.name) { Analytics() }
            composable(Screens.AboutMemberScreen.name) { AboutMember(navController) }
        }
    }
}

@Composable
fun MyBottomBarNavigation(navController: NavController) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

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


@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}