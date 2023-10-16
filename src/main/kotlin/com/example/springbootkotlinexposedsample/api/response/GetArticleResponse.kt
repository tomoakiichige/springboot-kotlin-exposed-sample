package com.example.springbootkotlinexposedsample.api.response

import com.example.springbootkotlinexposedsample.dto.ArticleDto

data class GetArticleResponse(
    val article: Article
) {
    companion object {
        fun from(dto: ArticleDto): GetArticleResponse {
            return GetArticleResponse(
                article = Article.from(dto)
            )
        }
    }
}
