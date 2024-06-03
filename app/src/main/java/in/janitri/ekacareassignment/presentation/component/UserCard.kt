package `in`.janitri.ekacareassignment.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import `in`.janitri.ekacareassignment.domain.model.User


@Composable
fun UserCard(user: User) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${user.name}", style = MaterialTheme.typography.headlineMedium)
            Text(text = "Age: ${user.age}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "DOB: ${user.dob}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Address: ${user.address}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

