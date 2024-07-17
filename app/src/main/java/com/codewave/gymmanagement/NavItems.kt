package com.codewave.gymmanagement

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.codewave.gymmanagement.appdata.Screens

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
            route = Screens.RegisterScreen.name
        ),
        NavItem(
            label = "Members",
            icon = Icons.Default.Person,
            route = Screens.MembersScreens.name
        ),
        NavItem(
            label = "History",
            icon = GetIconNav(icon = R.drawable.baseline_history_24),
            route = Screens.HistoryScreens.name
        ),
        NavItem(
            label = "Analytic",
            icon = GetIconNav(icon = R.drawable.baseline_analytics_24),
            route = Screens.AnalyticsScreens.name
        )
    )

@Composable
fun GetIconNav(icon:Int):ImageVector {
    return ImageVector.vectorResource(id = icon)
}