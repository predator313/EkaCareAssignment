package `in`.janitri.ekacareassignment.repository

import androidx.lifecycle.LiveData
import `in`.janitri.ekacareassignment.db.UserDao
import `in`.janitri.ekacareassignment.db.model.User

class Repository(private val userDao: UserDao) {
    suspend fun insert(user: User){
        userDao.insert(user)
    }

    fun getAllUsers():LiveData<List<User>>{
        return userDao.getAllUsers()
    }
}