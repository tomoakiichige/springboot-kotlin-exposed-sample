package com.example.springbootkotlinexposedsample.model

import java.time.Instant
import java.util.UUID

data class Tag(
    val id: UUID,
    val createdAt: Instant,
    val updatedAt: Instant,
    var name: String
)
