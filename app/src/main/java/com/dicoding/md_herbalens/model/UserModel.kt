package com.dicoding.md_herbalens.model

data class UserModel(
    val name: String,
    val email: String,
    val password: String,
    val role: String,
    val isLogin: Boolean
)
