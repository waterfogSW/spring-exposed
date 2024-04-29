package org.waterfogsw.springexposed.application.port.outbound

import org.waterfogsw.springexposed.domain.Post
import java.util.UUID

interface PostRepository {

    fun save(post: Post)
    fun updateById(id: UUID, post: Post)
    fun findAll(): List<Post>
    fun findById(id: UUID): Post?
    fun deleteById(id: UUID)

}
