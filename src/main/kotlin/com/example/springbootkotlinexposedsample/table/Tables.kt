package com.example.springbootkotlinexposedsample.table

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.timestampWithTimeZone


object ArticleTable : UUIDTable("article") {
    val createdAt = timestampWithTimeZone("created_at")
    val updatedAt = timestampWithTimeZone("updated_at")
    val slug = text("slug").uniqueIndex()
    val title = text("title")
    val description = text("description")
    val body = text("body")
    val authorId = reference("author_id", UserTable)
}

object UserTable : UUIDTable("user") {
    val createdAt = timestampWithTimeZone("created_at")
    val updatedAt = timestampWithTimeZone("updated_at")
    val email = text("email")
    val password = text("password")
    val username = text("username")
    val bio = text("bio")
    val image = text("image").nullable()
}

object CommentTable : UUIDTable("comment") {
    val createdAt = timestampWithTimeZone("created_at")
    val updatedAt = timestampWithTimeZone("updated_at")
    val body = text("body")
    val authorId = reference("author_id", UserTable)
    val articleId = reference("article_id", ArticleTable)
}

object TagTable : UUIDTable("tag") {
    val createdAt = timestampWithTimeZone("created_at")
    val updatedAt = timestampWithTimeZone("updated_at")
    val name = text("name")
}

object ArticleTagTable : UUIDTable("article_tag") {
    val createdAt = timestampWithTimeZone("created_at")
    val updatedAt = timestampWithTimeZone("updated_at")
    val articleId = reference("article_id", ArticleTable)
    val tagId = reference("tag_id", TagTable)
}

object ArticleFavoriteTable : UUIDTable("article_favorite") {
    val createdAt = timestampWithTimeZone("created_at")
    val updatedAt = timestampWithTimeZone("updated_at")
    val articleId = reference("article_id", ArticleTable)
    val userId = reference("user_id", UserTable)
}

object FollowTable : UUIDTable("Follow") {
    val createdAt = timestampWithTimeZone("created_at")
    val updatedAt = timestampWithTimeZone("updated_at")
    val followerId = reference("follower_id", UserTable)
    val followedId = reference("followed_id", UserTable)
}
