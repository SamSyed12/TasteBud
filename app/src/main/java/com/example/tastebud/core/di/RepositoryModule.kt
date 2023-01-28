package com.example.tastebud.core.di

import com.example.tastebud.login.data.UserRepositoryImpl
import com.example.tastebud.login.data.firebase_auth.FirebaseAuth
import com.example.tastebud.login.data.firebase_auth.FirebaseAuthImpl
import com.example.tastebud.login.domain.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindFireBaseAuth(
        firebaseAuthImpl: FirebaseAuthImpl
    ): FirebaseAuth

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}


