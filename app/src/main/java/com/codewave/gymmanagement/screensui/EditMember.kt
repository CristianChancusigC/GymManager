package com.codewave.gymmanagement.screensui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.codewave.gymmanagement.appdata.EditScreen
import com.codewave.gymmanagement.appdata.Graph

@Composable
fun EditMember(navController: NavHostController) {
    Scaffold(
        topBar = { TopBarEdit(navController) },
    ) {
        innerPadding -> ContentEdit(modifier = Modifier.padding(innerPadding))
    }
    ContentEdit()
}

fun NavGraphBuilder.editNavGraph(navController: NavHostController){
navigation(
    route = Graph.EDIT,
    startDestination = EditScreen.EditMembers.route
){
    composable(route= EditScreen.EditMembers.route){
        EditMember(navController = navController)
    }
    /*composable(route= EditScreen.AddMembers.route){
        AddMember(navController = navController)
    }*/
}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarEdit(navController: NavHostController) {
    TopAppBar(
        title = { Text(text = "Edit Member") },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Go Back"
                )
            }
        },
        actions = {
            Button(onClick = { }) {
                Text(text = "Save")
            }
        }
    )
}

@Composable
fun ContentEdit(modifier: Modifier = Modifier) {
    // Your content goes here
    Box(modifier = modifier.fillMaxSize()) {
        Text("Content goes here")
    }
}

@Composable
fun ContentEdit() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 100.dp)
    ) {
        CircleAccount()

        HorizontalDivider(thickness = 2.dp, modifier = Modifier.padding(20.dp))

        CardEdit("Name", "Cris", Icons.Default.AccountCircle)
        Spacer(modifier = Modifier.height(20.dp))
        CardEdit("Number", "0987654321", Icons.Default.Phone)
        Spacer(modifier = Modifier.height(20.dp))
        CardInfo("Type Sub", "Monthly", Icons.Default.CheckCircle)
        Spacer(modifier = Modifier.height(20.dp))
        CardInfo("Start Date", "01/01/2024", Icons.Default.DateRange)
    }
}

@Composable
fun CircleAccount() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(100.dp)
            .background(Color.Cyan, shape = CircleShape)
    ) {
        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun CardEdit(title: String, number: String, iconCard: ImageVector) {
    var text by remember { mutableStateOf("Hello") }
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
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 40.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(imageVector = iconCard, contentDescription = null)
                Spacer(modifier = Modifier.width(16.dp))
                TextField(value = text, onValueChange = { text = it })
            }
        }
    }
}

@Composable
fun CardInfo(title: String, info: String, iconCard: ImageVector) {
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
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 40.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(imageVector = iconCard, contentDescription = null)
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(text = info)
                }

            }
        }
    }
}

@Preview
@Composable
fun EditPreview() {
    EditMember(navController = rememberNavController())
}