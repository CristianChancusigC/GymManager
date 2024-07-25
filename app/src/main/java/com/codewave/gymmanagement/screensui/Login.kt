package com.codewave.gymmanagement.screensui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codewave.gymmanagement.appdata.Graph

@Composable
fun Login(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Welcome", fontSize = 30.sp)
            HorizontalDivider(
                thickness = 2.dp,
                modifier = Modifier.padding(50.dp)
            )
            Button(onClick = {
                navController.navigate(Graph.HOME)
            }) {
                Text(text = "Login")
            }
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    Login(navController = navController)
}