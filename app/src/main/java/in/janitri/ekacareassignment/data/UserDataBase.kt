package `in`.janitri.ekacareassignment.data

import androidx.room.Database
import androidx.room.RoomDatabase
import `in`.janitri.ekacareassignment.domain.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDataBase:RoomDatabase() {
    abstract fun userDao():UserDao
}