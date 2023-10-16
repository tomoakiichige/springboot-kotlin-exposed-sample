package com.example.springbootkotlinexposedsample.dto

import com.example.springbootkotlinexposedsample.model.Article
import com.example.springbootkotlinexposedsample.model.Tag

data class ArticleDto(
    val article: Article,
    val tags: List<Tag>,
    val favorited: Boolean,
    val favoritesCount: Long,
    val author: ProfileDto
)
