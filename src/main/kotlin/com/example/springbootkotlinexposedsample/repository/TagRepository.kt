package com.example.springbootkotlinexposedsample.repository

import com.example.springbootkotlinexposedsample.table.TagTable
import com.example.springbootkotlinexposedsample.model.Tag
import org.jetbrains.exposed.sql.select
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class TagRepository {
    fun findByIds(ids: List<UUID>): List<Tag> {
        return TagTable.select { TagTable.id inList ids }.map {
            Tag(
                id = it[TagTable.id].value,
                createdAt = it[TagTable.createdAt].toInstant(),
                updatedAt = it[TagTable.updatedAt].toInstant(),
                name = it[TagTable.name]
            )
        }
    }
}
