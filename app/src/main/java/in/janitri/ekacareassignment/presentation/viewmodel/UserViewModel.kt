package `in`.janitri.ekacareassignment.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.janitri.ekacareassignment.domain.model.User
import `in`.janitri.ekacareassignment.domain.repository.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: Repository
) :ViewModel(){
    private val _allUsers = MutableLiveData<List<User>>()
    val allUsers:LiveData<List<User>> = _allUsers

    //to handle visibility of dialog
    private val _showAddUserDialog = MutableLiveData<Boolean>()
    val showAddUserDialog: LiveData<Boolean> = _showAddUserDialog

    init {
        repository.getAllUsers().observeForever {users->
            _allUsers.value=users

        }
        _showAddUserDialog.value = false
    }


    fun insertUser(user: User){
        viewModelScope.launch {
            repository.insert(user)
        }
    }

    fun setShowAddUserDialog(show: Boolean) {
        _showAddUserDialog.value = show
    }

    override fun onCleared() {
        super.onCleared()
        repository.getAllUsers().removeObserver {  }
    }
}