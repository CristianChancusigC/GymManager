package com.codewave.gymmanagement

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.codewave.gymmanagement.appdata.HomeScreen

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItem: List<NavItem>
    @Composable
    get() = listOf(
        NavItem(
            label = "Register",
            icon = GetIconNav(icon = R.drawable.baseline_app_registration_24),
            route = HomeScreen.Register.route
        ),
        NavItem(
            label = "Members",
            icon = Icons.Default.Person,
            route = HomeScreen.Members.route
        ),
        NavItem(
            label = "History",
            icon = GetIconNav(icon = R.drawable.baseline_history_24),
            route = HomeScreen.History.route
        ),
        NavItem(
            label = "Analytic",
            icon = GetIconNav(icon = R.drawable.baseline_analytics_24),
            route = HomeScreen.Analytics.route
        )
    )

@Composable
fun GetIconNav(icon:Int):ImageVector {
    return ImageVector.vectorResource(id = icon)
}