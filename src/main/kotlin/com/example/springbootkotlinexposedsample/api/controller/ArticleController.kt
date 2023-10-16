package com.example.springbootkotlinexposedsample.api.controller

import com.example.springbootkotlinexposedsample.api.response.GetArticleResponse
import com.example.springbootkotlinexposedsample.usecase.GetArticleUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController("/api/article")
class ArticleController(private val getArticleUseCase: GetArticleUseCase) {
    @GetMapping("{slug}")
    fun findBySlug(@PathVariable slug: String): GetArticleResponse {
        return GetArticleResponse.from(getArticleUseCase.execute(slug))
    }
}
