package com.example.springbootkotlinexposedsample.api

import com.example.springbootkotlinexposedsample.api.response.ErrorResponse
import com.example.springbootkotlinexposedsample.exception.DataInconsistencyException
import com.example.springbootkotlinexposedsample.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorResponse(
                code = "NOT_FOUND",
                message = "Not Found"
            )
        )
    }

    @ExceptionHandler(Exception::class)
    fun handleOtherException(): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            ErrorResponse(
                code = "INTERNAL_SERVER_ERROR",
                message = "Internal Server Error"
            )
        )
    }
}
