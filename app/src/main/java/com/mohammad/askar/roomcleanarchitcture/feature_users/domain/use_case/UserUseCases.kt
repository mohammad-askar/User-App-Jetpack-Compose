package com.mohammad.askar.roomcleanarchitcture.feature_users.domain.use_case

import javax.inject.Inject

data class UserUseCases @Inject constructor(
    val getAllUsersUseCase: GetAllUsersUseCase,
    val getUserByIdUseCase: GetUserByIdUseCase,
    val insertUserUseCase: InsertUserUseCase,
    val deleteUserUseCase: DeleteUserUseCase
)
