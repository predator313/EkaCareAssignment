package `in`.janitri.ekacareassignment.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "user_table")
data class User(
    val name: String,
    val age: Int,
    val dob: String,
    val address: String,
    @PrimaryKey(autoGenerate = true)
    val id:Int=0
)
