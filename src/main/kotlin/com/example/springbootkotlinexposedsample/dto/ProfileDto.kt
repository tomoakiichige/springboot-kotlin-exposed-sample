package com.example.springbootkotlinexposedsample.dto

import com.example.springbootkotlinexposedsample.model.User

data class ProfileDto(
    val user: User,
    val following: Boolean
)
