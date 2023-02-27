package com.mohammad.askar.roomcleanarchitcture.di

import android.app.Application
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.CoroutinesRoom
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mohammad.askar.roomcleanarchitcture.feature_users.data.local.UserDatabase
import com.mohammad.askar.roomcleanarchitcture.feature_users.data.local.dao.UserDao
import com.mohammad.askar.roomcleanarchitcture.feature_users.data.repository.UserRepositoryImpl
import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.model.User
import com.mohammad.askar.roomcleanarchitcture.feature_users.domain.repository.UserRepository
import com.mohammad.askar.roomcleanarchitcture.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Provides
    @Singleton
    fun providesUserDataBase(app: Application) =
        Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun providesRepository(db: UserDatabase): UserRepository {
        return UserRepositoryImpl(userDao = db.userDao)
    }
}