package com.example.springbootkotlinexposedsample.model

import java.time.Instant
import java.util.UUID

data class ArticleFavorite(
    val id: UUID,
    val createdAt: Instant,
    val updatedAt: Instant,
    var articleId: UUID,
    var userId: UUID
)
