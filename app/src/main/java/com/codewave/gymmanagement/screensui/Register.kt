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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.codewave.gymmanagement.appdata.DetailsScreen
import com.codewave.gymmanagement.appdata.MemberInfo
import com.codewave.gymmanagement.appdata.getAllMember

@Composable
fun Register(navController: NavHostController) {
    var show = rememberSaveable { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Register")
            Button(onClick = { show.value=true}) {

            }
            ListMembers(navController)
        }
    }
    DialogInfo(show,{ show.value = false })
}

@Composable
fun ListMembers(navController: NavHostController) {
    var myMembers = getAllMember()
    LazyColumn(content = {
        itemsIndexed(myMembers, itemContent = { _, item ->
            MemberItem(navController, item)
        })
    })
}

@Composable
fun MemberItem(navController: NavHostController, item: MemberInfo) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate(DetailsScreen.InfoMembers.route) }
        //.clickable (onClick = {show=true})
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

@Composable
fun DialogInfo(
    show: MutableState<Boolean>,
    onConfirm: () -> Unit
) {
    if (show.value) {
        AlertDialog(
            onDismissRequest = { onConfirm },
            confirmButton = {
                TextButton(onClick = { onConfirm }) {
                    Text(text = "Ok")
                }
            },
            title = { Text(text = "Welcome") },
            text = { Text(text = "You are A member ") }
        )
    }
}