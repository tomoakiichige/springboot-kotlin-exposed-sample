package com.example.springbootkotlinexposedsample.usecase

import com.example.springbootkotlinexposedsample.dto.ArticleDto
import com.example.springbootkotlinexposedsample.dto.ProfileDto
import com.example.springbootkotlinexposedsample.exception.DataInconsistencyException
import com.example.springbootkotlinexposedsample.exception.NotFoundException
import com.example.springbootkotlinexposedsample.repository.ArticleFavoriteRepository
import com.example.springbootkotlinexposedsample.repository.ArticleRepository
import com.example.springbootkotlinexposedsample.repository.TagRepository
import com.example.springbootkotlinexposedsample.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class GetArticleUseCase(
    private val articleRepository: ArticleRepository,
    private val userRepository: UserRepository,
    private val articleFavoriteRepository: ArticleFavoriteRepository,
    private val tagRepository: TagRepository
) {
    fun execute(slug: String): ArticleDto {
        val article = articleRepository.findBySlug(slug) ?: throw NotFoundException("article not found: articleId=$slug")
        val author = userRepository.findById(article.authorId) ?: throw DataInconsistencyException("author not found: articleId=$slug, authorId=${article.authorId}")
        val favoritesCount = articleFavoriteRepository.countByArticleId(article.id)
        val tags = tagRepository.findByIds(article.tagIds)
        return ArticleDto(
            article = article,
            tags = tags,
            favorited = false,
            favoritesCount = favoritesCount,
            author = ProfileDto(
                user = author,
                following = false
            )
        )
    }
}
