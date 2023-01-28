package com.example.tastebud.login.data.firebase_auth

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

class FirebaseAuthImpl : FirebaseAuth {
    private val firebaseAuth = com.google.firebase.auth.FirebaseAuth.getInstance()

    override fun signInWithEmail(email: String, password: String): Task<AuthResult> =
        firebaseAuth.signInWithEmailAndPassword(email, password)
}