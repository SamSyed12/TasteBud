package com.example.tastebud.login.data

import com.example.tastebud.core.util.Resource
import com.example.tastebud.login.data.firebase_auth.FirebaseAuth
import com.example.tastebud.login.domain.User
import com.example.tastebud.login.domain.UserRepository
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class UserRepositoryImpl(
    private val firebaseAuth: FirebaseAuth
) : UserRepository {
    var currentUser: User = User()
        private set

    override suspend fun signIn(
        username: String,
        password: String
    ): Resource<Boolean> {
        return suspendCoroutine { continuation ->
            firebaseAuth.signInWithEmail(username, password)
                .addOnSuccessListener {
                    currentUser = User(username = username)
                    continuation.resume(Resource.Success(data = true ))
                }
                .addOnFailureListener { exception ->
                    continuation.resume(
                        Resource.Error(
                            data = false,
                            message = exception.message ?: "Error getting message"
                        )
                    )
                }
        }
    }
    override fun getLoggedInUser(): User = currentUser
}
