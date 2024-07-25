package com.codewave.gymmanagement.screensui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.codewave.gymmanagement.appdata.EditScreen

@Composable
fun AboutMember(navController: NavHostController) {
    Scaffold(
        topBar = { TopBarInfoMember(navController) },
    ) { innerPadding ->
        ContentMember(modifier = Modifier.padding(innerPadding))
    }

    ContentMember()
}

@Composable
fun ContentMember(modifier: Modifier = Modifier) {
    // Your content goes here
    Box(modifier = modifier.fillMaxSize()) {
        Text("Content goes here")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarInfoMember(navController: NavHostController) {
    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Info") },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Go Back"
                )
            }
        },
        actions = {
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More"
                )
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }) {
                DropdownMenuItem(
                    text = { Text(text = "Edit") },
                    onClick = { navController.navigate(EditScreen.EditMembers.route) })
                DropdownMenuItem(text = { Text(text = "Delete") }, onClick = { })
                DropdownMenuItem(text = { Text(text = "Renew") }, onClick = { })
            }
        }
    )
}

@Composable
fun ContentMember() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 100.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan, shape = CircleShape)
        ) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Name",
            fontSize = 20.sp,
        )

        HorizontalDivider(thickness = 2.dp, modifier = Modifier.padding(20.dp))

        CardInfo("Number", "0987654321")
        Spacer(modifier = Modifier.height(20.dp))
        CardInfo("Type Sub", "Monthly")
        Spacer(modifier = Modifier.height(20.dp))
        CardInfo("Start Date", "01/01/2024")
        Spacer(modifier = Modifier.height(20.dp))
        CardInfo("Finish Date", "01/02/2024")
    }

}

@Composable
fun CardInfo(title: String, number: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
            .height(80.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = number,
                fontSize = 20.sp
            )
        }
    }
}

@Preview
@Composable
fun AboutMemberPrev() {
    AboutMember(navController = rememberNavController())
}