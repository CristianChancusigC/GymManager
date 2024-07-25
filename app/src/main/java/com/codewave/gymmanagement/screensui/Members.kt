package com.codewave.gymmanagement.screensui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.codewave.gymmanagement.appdata.DetailsScreen
import com.codewave.gymmanagement.appdata.EditScreen
import com.codewave.gymmanagement.appdata.MemberInfo
import com.codewave.gymmanagement.appdata.getAllMember

@Composable
fun Members(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Members")
            Button(onClick = { navController.navigate(EditScreen.AddMembers.route)}) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Add"
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Add Member")
            }
            ListInfoMembers(navController)
        }
    }
}

@Composable
fun ListInfoMembers(navController: NavHostController) {
    var myMembers = getAllMember()
    LazyColumn(content = {
        itemsIndexed(myMembers, itemContent = { _, item ->
            InfoMemberItem(navController, item)
        })
    })
}

@Composable
fun InfoMemberItem(navController: NavHostController, item: MemberInfo) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate(DetailsScreen.InfoMembers.route) }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .background(Color.Blue, shape = CircleShape)
        ) {
            Text(
                text = item.name.first().uppercase(),
                fontSize = 25.sp,
            )
        }
        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = item.name,
            fontSize = 20.sp,
        )
    }
}

@Preview
@Composable
private fun PrevMembers() {
    Members(navController = rememberNavController())
}