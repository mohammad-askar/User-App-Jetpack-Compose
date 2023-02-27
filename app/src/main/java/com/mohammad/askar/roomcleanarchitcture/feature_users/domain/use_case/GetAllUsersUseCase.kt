package com.mohammad.askar.roomcleanarchitcture.feature_users.domain.use_case

import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.model.User
import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {

    operator fun invoke(): Flow<List<User>> =
        repository.getAllUsers()
}