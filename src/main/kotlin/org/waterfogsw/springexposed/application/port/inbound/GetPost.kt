package org.waterfogsw.springexposed.application.port.inbound

import org.waterfogsw.springexposed.domain.Post

interface GetPost {

    fun getList(): List<Post>

}
