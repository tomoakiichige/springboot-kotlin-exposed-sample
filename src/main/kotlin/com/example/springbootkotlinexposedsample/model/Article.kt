package com.example.springbootkotlinexposedsample.model

import java.time.Instant
import java.util.UUID

data class Article(
    val id: UUID,
    val createdAt: Instant,
    val updatedAt: Instant,
    var slug: String,
    var title: String,
    var description: String,
    var body: String,
    var authorId: UUID,
    var tagIds: MutableList<UUID>
)
