package com.mohammad.askar.roomcleanarchitcture.feature_users.presentation.home

import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.model.User

data class HomeState(
    val users: List<User> = emptyList()
)