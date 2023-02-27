package com.mohammad.askar.roomcleanarchitcture.feature_users.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohammad.askar.roomcleanarchitcture.feature_users.data.local.dao.UserDao
import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.model.User

@Database(
    version = 1,
    entities = [User::class],
    exportSchema = false
)
abstract class UserDatabase(

) : RoomDatabase() {
    abstract val userDao: UserDao
}