package com.example.tastebud.login.data.firebase_auth

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface FirebaseAuth {
    fun signInWithEmail(
        email: String,
        password: String
    ): Task<AuthResult>
}