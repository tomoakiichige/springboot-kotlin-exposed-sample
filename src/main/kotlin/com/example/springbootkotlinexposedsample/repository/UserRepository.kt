package com.example.springbootkotlinexposedsample.repository

import com.example.springbootkotlinexposedsample.table.UserTable
import com.example.springbootkotlinexposedsample.model.User
import org.jetbrains.exposed.sql.select
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UserRepository {
    fun findById(id: UUID): User? {
        return UserTable.select { UserTable.id eq id }.firstOrNull()?.let {
            User(
                id = it[UserTable.id].value,
                createdAt = it[UserTable.createdAt].toInstant(),
                updatedAt = it[UserTable.updatedAt].toInstant(),
                email = it[UserTable.email],
                password = it[UserTable.password],
                username = it[UserTable.username],
                bio = it[UserTable.bio],
                image = it[UserTable.image],
            )
        }
    }
}
