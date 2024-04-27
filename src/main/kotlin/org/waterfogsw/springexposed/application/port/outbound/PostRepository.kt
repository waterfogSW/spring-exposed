package org.waterfogsw.springexposed.application.port.outbound

import org.waterfogsw.springexposed.domain.Post

interface PostRepository {

    fun save(post: Post)
    fun findAll(): List<Post>

}
