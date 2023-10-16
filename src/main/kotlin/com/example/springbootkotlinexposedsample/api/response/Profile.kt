package com.example.springbootkotlinexposedsample.api.response

data class Profile(
    val username: String,
    val bio: String,
    val image: String?,
    val following: Boolean
)
