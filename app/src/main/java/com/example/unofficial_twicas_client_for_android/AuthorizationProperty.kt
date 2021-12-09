package com.example.unofficial_twicas_client_for_android

data class AuthorizationProperty(
    val token_type: String,
    val expires_in: Int,
    val access_token: String
)
