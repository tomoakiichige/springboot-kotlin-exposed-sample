package com.example.springbootkotlinexposedsample.model

import java.time.Instant
import java.util.UUID

data class Follow(
    val id: UUID,
    val createdAt: Instant,
    val updatedAt: Instant,
    var followerId: UUID,
    var followedId: UUID
)
