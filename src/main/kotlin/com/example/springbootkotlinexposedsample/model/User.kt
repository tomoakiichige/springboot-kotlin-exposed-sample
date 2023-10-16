package com.example.springbootkotlinexposedsample.model

import java.time.Instant
import java.util.UUID

data class User(
    val id: UUID,
    val createdAt: Instant,
    val updatedAt: Instant,
    var email: String,
    var password: String,
    var username: String,
    var bio: String,
    var image: String?
)
