package com.mohammad.askar.roomcleanarchitcture.feature_users.domain.repository

import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getAllUsers(): Flow<List<User>>

    suspend fun getUserById(id: Int): User?

    suspend fun insertUser(user: User)

    suspend fun deleteUser(user: User)
}