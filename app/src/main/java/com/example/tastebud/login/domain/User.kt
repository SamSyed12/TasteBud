package com.example.tastebud.login.domain

data class User(
    val username: String = ""
) {
    companion object {
        val guestUser = User("")
    }
}
