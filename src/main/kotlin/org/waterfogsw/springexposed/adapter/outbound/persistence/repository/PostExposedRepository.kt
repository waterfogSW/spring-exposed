package org.waterfogsw.springexposed.adapter.outbound.persistence.repository

import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import org.waterfogsw.springexposed.adapter.outbound.persistence.table.PostExposedEntity
import org.waterfogsw.springexposed.adapter.outbound.persistence.table.PostTable
import org.waterfogsw.springexposed.application.port.outbound.PostRepository
import org.waterfogsw.springexposed.domain.Post

@Repository
class PostExposedRepository : PostRepository {

    override fun save(post: Post) {
        PostExposedEntity.toExposedEntity(post)
    }

    override fun findAll() = PostTable
        .selectAll()
        .map { PostExposedEntity.wrapRow(it).toDomain() }
}
