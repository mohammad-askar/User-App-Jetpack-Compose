package com.mohammad.askar.roomcleanarchitcture.feature_users.data.repository

import com.mohammad.askar.roomcleanarchitcture.feature_users.data.local.dao.UserDao
import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.model.User
import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {

    override fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }

    override suspend fun getUserById(id: Int): User? {
        return userDao.getUserById(id = id)
    }

    override suspend fun insertUser(user: User) {
        userDao.insertUser(user = user)
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user = user)
    }
}