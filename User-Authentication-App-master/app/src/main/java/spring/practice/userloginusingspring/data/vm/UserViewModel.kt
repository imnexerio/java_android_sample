package spring.practice.userloginusingspring.data.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import spring.practice.userloginusingspring.data.model.UserData
import spring.practice.userloginusingspring.data.repo.UserRepository

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val _createUserResult: MutableStateFlow<Boolean?> = MutableStateFlow(null)
    val createUserResult: StateFlow<Boolean?> = _createUserResult

    fun createUser(userData: UserData) {
        viewModelScope.launch {
            try {
                // Call the repository method to create the user
                repository.createUser(userData)
                // If successful, set the result to true
                _createUserResult.value = true

            } catch (e: Exception) {
                // If an error occurs, set the result to false
                _createUserResult.value = false
                // You can also handle and log the error here
                Log.e("HappyError", "An error occurred: ${e.message}");
            }
        }
    }
}