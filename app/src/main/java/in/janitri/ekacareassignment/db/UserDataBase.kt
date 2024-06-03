package `in`.janitri.ekacareassignment.db

import androidx.room.Database
import androidx.room.RoomDatabase
import `in`.janitri.ekacareassignment.db.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDataBase:RoomDatabase() {
    abstract fun userDao():UserDao
}