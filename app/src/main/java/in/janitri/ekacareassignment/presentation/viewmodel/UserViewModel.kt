package `in`.janitri.ekacareassignment.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.janitri.ekacareassignment.db.model.User
import `in`.janitri.ekacareassignment.repository.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: Repository
) :ViewModel(){
    private val _allUsers = MutableLiveData<List<User>>()
    val allUsers:LiveData<List<User>> = _allUsers

    init {
        repository.getAllUsers().observeForever {users->
            _allUsers.value=users

        }
    }


    fun insertUser(user: User){
        viewModelScope.launch {
            repository.insert(user)
        }
    }

    override fun onCleared() {
        super.onCleared()
        repository.getAllUsers().removeObserver {  }
    }
}