package com.example.springbootkotlinexposedsample.api.response

import com.example.springbootkotlinexposedsample.dto.ArticleDto
import java.time.ZoneId
import java.time.ZonedDateTime

data class Article(
    val slug: String,
    val title: String,
    val description: String,
    val body: String,
    val tagList: List<String>,
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime,
    val favorited: Boolean,
    val favoritesCount: Long,
    val author: Profile
) {
    companion object {
        fun from(dto: ArticleDto): Article {
            return Article(
                slug = dto.article.slug,
                title = dto.article.title,
                description = dto.article.description,
                body = dto.article.body,
                tagList = dto.tags.map { it.name },
                createdAt = dto.article.createdAt.atZone(ZoneId.of("UTC")),
                updatedAt = dto.article.updatedAt.atZone(ZoneId.of("UTC")),
                favorited = dto.favorited,
                favoritesCount = dto.favoritesCount,
                author = Profile(
                    username = dto.author.user.username,
                    bio = dto.author.user.bio,
                    image = dto.author.user.image,
                    following = dto.author.following
                )
            )
        }
    }
}
