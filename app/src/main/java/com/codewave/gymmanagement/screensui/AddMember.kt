package com.codewave.gymmanagement.screensui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
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
import com.codewave.gymmanagement.appdata.MemberInfo
import com.codewave.gymmanagement.appdata.SubscriptionsInfo
import com.codewave.gymmanagement.appdata.getAllTypeSubs
import java.time.Instant
import java.time.ZoneId

@Composable
fun AddMember(navController: NavHostController) {
    Scaffold(
        topBar = { TopBarAdd(navController) },
    ) { innerPadding ->
        ContentEdit(modifier = Modifier.padding(innerPadding))
    }
    ContAddMember()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarAdd(navController: NavHostController) {
    TopAppBar(
        title = { Text(text = "Add Member") },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
        }
    )
}

@Composable
fun ContAddMember() {
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
        CardAddSub()
        Spacer(modifier = Modifier.height(20.dp))
        //CardInfo("Start Date", "01/01/2024", Icons.Default.DateRange)
        CardDate()
    }
}

@Composable
fun CardAddSub() {
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
                text = "Type Sub",
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
                Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null)
                Spacer(modifier = Modifier.width(16.dp))
                MenuSubs(getAllTypeSubs())
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDate() {
    val state = rememberDatePickerState()
    var showDialog by remember {
        mutableStateOf(false)
    }
    /*Column {
        Button(onClick = { showDialog = true }) {
            Text(text = "Date")
        }
        if (showDialog) {
            DatePickerDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text(text = "Confirm")
                    }
                }) {
                DatePicker(state = state)
            }
        }
    }*/

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
                text = "Start Date",
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
                Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp)
                        .clickable { showDialog = true },
                    contentAlignment = Alignment.CenterStart
                ) {
                    val date = state.selectedDateMillis
                    date?.let {
                        val localDate =
                            Instant.ofEpochMilli(it).atZone(ZoneId.of("UTC")).toLocalDate()
                        Text(text = "${localDate.dayOfMonth}/${localDate.monthValue}/${localDate.year}")
                    }
                }
                if (showDialog) {
                    DatePickerDialog(
                        onDismissRequest = { showDialog = false },
                        confirmButton = {
                            Button(onClick = { showDialog = false }) {
                                Text(text = "Confirm")
                            }
                        },
                        dismissButton = {
                            OutlinedButton(onClick = { showDialog = false }) {
                                Text(text = "Cancel")
                            }
                        }) {
                        DatePicker(state = state)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuSubs(options: List<SubscriptionsInfo>) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var subGym by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }) {
            TextField(
                value = subGym,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                options.forEach {
                    DropdownMenuItem(
                        text = { Text(text = it.typeSub) },
                        onClick = {
                            subGym = it.typeSub
                            isExpanded = false
                        })
                    // contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding)
                }
                /*DropdownMenuItem(
                    text = { Text(text = "Monthly") },
                    onClick = {
                        subGym = "Monthly"
                        isExpanded = !isExpanded
                    })
                DropdownMenuItem(
                    text = { Text(text = "Year") },
                    onClick = {
                        subGym = "Year"
                        isExpanded = !isExpanded
                    })*/
            }
        }
    }
}

@Preview
@Composable
private fun PrevAddMember() {
    AddMember(navController = rememberNavController())
}