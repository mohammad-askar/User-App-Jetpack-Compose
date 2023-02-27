package com.mohammad.askar.roomcleanarchitcture.feature_users.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mohammad.askar.roomcleanarchitcture.util.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int? = 0,
    val name: String = "name",
    val lastName: String = "last name",
    val age: Int = 33
)
