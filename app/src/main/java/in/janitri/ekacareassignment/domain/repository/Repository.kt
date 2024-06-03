package `in`.janitri.ekacareassignment.domain.repository

import androidx.lifecycle.LiveData
import `in`.janitri.ekacareassignment.data.UserDao
import `in`.janitri.ekacareassignment.domain.model.User

class Repository(private val userDao: UserDao) {
    suspend fun insert(user: User){
        userDao.insert(user)
    }

    fun getAllUsers():LiveData<List<User>>{
        return userDao.getAllUsers()
    }
}