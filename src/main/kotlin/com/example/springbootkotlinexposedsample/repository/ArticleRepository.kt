package com.example.springbootkotlinexposedsample.repository

import com.example.springbootkotlinexposedsample.table.ArticleTable
import com.example.springbootkotlinexposedsample.table.ArticleTagTable
import com.example.springbootkotlinexposedsample.model.Article
import org.jetbrains.exposed.sql.select
import org.springframework.stereotype.Component

@Component
class ArticleRepository {
    fun findBySlug(slug: String): Article? {
        val article = ArticleTable.select { ArticleTable.slug eq slug }.firstOrNull() ?: return null
        val articleId = article[ArticleTable.id]
        val tags = ArticleTagTable.select { ArticleTagTable.articleId eq articleId }
        return Article(
            id = article[ArticleTable.id].value,
            createdAt = article[ArticleTable.createdAt].toInstant(),
            updatedAt = article[ArticleTable.updatedAt].toInstant(),
            slug = article[ArticleTable.slug],
            title = article[ArticleTable.title],
            description = article[ArticleTable.description],
            body = article[ArticleTable.body],
            authorId = article[ArticleTable.authorId].value,
            tagIds = tags.map { it[ArticleTagTable.tagId].value }.toMutableList()
        )
    }
}
