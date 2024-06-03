package `in`.janitri.ekacareassignment.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import `in`.janitri.ekacareassignment.presentation.component.AddUser
import `in`.janitri.ekacareassignment.presentation.component.UserList
import `in`.janitri.ekacareassignment.presentation.viewmodel.UserViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(viewModel: UserViewModel){
    val allUsers by viewModel.allUsers.observeAsState(emptyList())
    val showDialog by viewModel.showAddUserDialog.observeAsState(false)


    if (showDialog) {
        AddUser(onDismiss = { viewModel.setShowAddUserDialog(false) }) { user ->
            viewModel.insertUser(user)
            viewModel.setShowAddUserDialog(false)
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.setShowAddUserDialog(true) }) {
                Text("+")
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)
                    .padding(16.dp)
            ) {
                UserList(users = allUsers)
            }
        }
    )
}
