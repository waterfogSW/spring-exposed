package org.waterfogsw.springexposed.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.waterfogsw.springexposed.application.port.inbound.GetPost
import org.waterfogsw.springexposed.application.port.outbound.PostRepository
import org.waterfogsw.springexposed.common.exception.NotFoundException
import org.waterfogsw.springexposed.domain.Post
import java.util.*

@Service
@Transactional(readOnly = true)
class PostQueryService(
    private val postRepository: PostRepository,
) : GetPost {

    override fun getList(): List<Post> {
        return postRepository.findAll()
    }

    override fun getById(id: UUID): Post {
        return postRepository
            .findById(id)
            ?: throw NotFoundException("해당 ID의 게시글이 존재하지 않습니다")
    }

}
