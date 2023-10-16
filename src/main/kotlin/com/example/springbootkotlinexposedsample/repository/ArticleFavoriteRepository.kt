package com.example.springbootkotlinexposedsample.repository

import com.example.springbootkotlinexposedsample.table.ArticleFavoriteTable
import org.jetbrains.exposed.sql.select
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ArticleFavoriteRepository {
    fun countByArticleId(articleId: UUID): Long {
        return ArticleFavoriteTable.select { ArticleFavoriteTable.articleId eq articleId }.count()
    }
}
