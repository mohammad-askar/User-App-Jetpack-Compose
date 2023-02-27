package com.mohammad.askar.roomcleanarchitcture.feature_users.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.model.User
import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.use_case.GetAllUsersUseCase
import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.use_case.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UserUseCases,
    getAllUsersUseCase: GetAllUsersUseCase
) : ViewModel() {

    private val _homeState = MutableStateFlow(value = HomeState())
    val homeState: StateFlow<HomeState> = _homeState.asStateFlow()

    init {
        getAllUsersUseCase().onEach { users ->
            _homeState.update { homeState ->
                val users = listOf(User(), User(), User())
                homeState.copy(users = users)
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: HomeEvent) {

        when (event) {
            is HomeEvent.DeleteUser -> {
                viewModelScope.launch {
                    useCases.deleteUserUseCase(user = event.user)
                }
            }
        }
    }
}