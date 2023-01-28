package com.example.tastebud.login.domain

import com.example.tastebud.core.util.Resource

interface UserRepository {

    suspend fun signIn(
        username: String,
        password: String
    ): Resource<Boolean>

    fun getLoggedInUser(): User

}