package com.codewave.gymmanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.codewave.gymmanagement.graphs.RootNavigationGraph
import com.codewave.gymmanagement.ui.theme.GymManagementTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GymManagementTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootNavigationGraph(navController = rememberNavController())
                }
            }
        }
    }
}

/*@Composable
fun LoginMain() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.LoginScreen.name,
        builder = {
            composable(Screens.LoginScreen.name) { Login(navController) }
            composable(Screens.MainScreen.name) { MainScreen() }
        }
    )
}*/