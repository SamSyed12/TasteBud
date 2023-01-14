package com.example.tastebud.login.data

import android.util.Log
import com.example.tastebud.login.domain.User
import com.example.tastebud.core.util.Resource
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class UserRepository {
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    var currentUser: User = User()
        private set

    suspend fun signIn(
        username: String,
        password: String
    ): Resource<Boolean> {
        return suspendCoroutine { continuation ->
            firebaseAuth.signInWithEmailAndPassword(username, password)
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
}
