package com.dicoding.md_herbalens.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("loginResult")
    val LoginResult: LoginResult?
)

data class LoginResult(
    @field:SerializedName("userId")
    var id: String,

    @field:SerializedName("name")
    var name: String,

    @field:SerializedName("token")
    var token: String
)
