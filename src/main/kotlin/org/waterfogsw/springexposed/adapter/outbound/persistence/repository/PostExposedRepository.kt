package org.waterfogsw.springexposed.adapter.outbound.persistence.repository

import kotlinx.datetime.toJavaLocalDateTime
import kotlinx.datetime.toKotlinLocalDateTime
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.springframework.stereotype.Repository
import org.waterfogsw.springexposed.adapter.outbound.persistence.table.PostTable
import org.waterfogsw.springexposed.application.port.outbound.PostRepository
import org.waterfogsw.springexposed.domain.Post

@Repository
class PostExposedRepository : PostRepository {

    override fun save(post: Post) {
        PostTable.insert {
            it[id] = post.id
            it[title] = post.title.value
            it[contents] = post.contents.value
            it[createdAt] = post.createdAt.toKotlinLocalDateTime()
            it[updatedAt] = post.updatedAt.toKotlinLocalDateTime()
        }
    }

    override fun findAll() = PostTable
        .selectAll()
        .map {
            Post(
                id = it[PostTable.id].value,
                title = Post.Title(it[PostTable.title]),
                contents = Post.Contents(it[PostTable.contents]),
                createdAt = it[PostTable.createdAt].toJavaLocalDateTime(),
                updatedAt = it[PostTable.updatedAt].toJavaLocalDateTime()
            )
        }
}
