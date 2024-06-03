package `in`.janitri.ekacareassignment.presentation.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import `in`.janitri.ekacareassignment.domain.model.User

@Composable
fun UserList(users: List<User>) {
    LazyColumn {
        items(users) { user ->
            UserCard(user)
        }
    }
}

