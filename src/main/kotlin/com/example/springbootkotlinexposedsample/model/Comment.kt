package com.example.springbootkotlinexposedsample.model

import java.time.Instant
import java.util.UUID

data class Comment(
    val id: UUID,
    val createdAt: Instant,
    val updatedAt: Instant,
    var body: String,
    var authorId: UUID,
    var articleId: UUID
)
