package com.mohammad.askar.roomcleanarchitcture.feature_users.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table ORDER BY id DESC")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM user_table WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}