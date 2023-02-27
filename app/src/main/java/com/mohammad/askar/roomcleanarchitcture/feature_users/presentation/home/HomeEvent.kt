package com.mohammad.askar.roomcleanarchitcture.feature_users.presentation.home

import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.model.User

sealed class HomeEvent {

    data class DeleteUser(val user: User) : HomeEvent()
}