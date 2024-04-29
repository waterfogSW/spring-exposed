package org.waterfogsw.springexposed.adapter.outbound.persistence.repository

import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import org.waterfogsw.springexposed.adapter.outbound.persistence.table.PostExposedEntity
import org.waterfogsw.springexposed.adapter.outbound.persistence.table.PostTable
import org.waterfogsw.springexposed.application.port.outbound.PostRepository
import org.waterfogsw.springexposed.domain.Post
import java.util.*

@Repository
class PostExposedRepository : PostRepository {

    override fun save(post: Post) {
        PostExposedEntity
            .new {
                title = post.title.value
                contents = post.contents.value
                createdAt = post.createdAt
                updatedAt = post.updatedAt
            }
    }

    override fun updateById(
        id: UUID,
        post: Post,
    ) {
        PostExposedEntity
            .findByIdAndUpdate(id) {
                it.title = post.title.value
                it.contents = post.contents.value
                it.createdAt = post.createdAt
                it.updatedAt = post.updatedAt
            }
    }


    override fun findAll() = PostTable
        .selectAll()
        .map { PostExposedEntity.wrapRow(it).toDomain() }

    override fun findById(id: UUID): Post? {
        return PostTable
            .selectAll()
            .where { PostTable.id eq id }
            .map { PostExposedEntity.wrapRow(it).toDomain() }
            .firstOrNull()
    }

}
