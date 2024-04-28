package org.waterfogsw.springexposed.application.port.inbound

import org.waterfogsw.springexposed.domain.Post
import java.util.UUID

interface GetPost {

    fun getList(): List<Post>
    fun getById(id: UUID): Post

}
