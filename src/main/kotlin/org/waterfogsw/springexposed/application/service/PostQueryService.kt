package org.waterfogsw.springexposed.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.waterfogsw.springexposed.application.port.inbound.GetPost
import org.waterfogsw.springexposed.application.port.outbound.PostRepository
import org.waterfogsw.springexposed.domain.Post

@Service
@Transactional(readOnly = true)
class PostQueryService(
    private val postRepository: PostRepository,
): GetPost {

    override fun getList(): List<Post> {
        return postRepository.findAll()
    }

}
