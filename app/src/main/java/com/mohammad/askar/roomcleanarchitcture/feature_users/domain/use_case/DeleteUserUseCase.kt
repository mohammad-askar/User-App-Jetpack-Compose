package com.mohammad.askar.roomcleanarchitcture.feature_users.domain.use_case

import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.model.User
import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.repository.UserRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    suspend operator fun invoke(user: User) =
        repository.deleteUser(user = user)
}