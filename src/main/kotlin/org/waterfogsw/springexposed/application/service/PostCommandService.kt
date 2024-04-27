package org.waterfogsw.springexposed.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.waterfogsw.springexposed.application.port.inbound.CreatePost
import org.waterfogsw.springexposed.application.port.outbound.PostRepository
import org.waterfogsw.springexposed.domain.Post

@Service
@Transactional
class PostCommandService (
    private val postRepository: PostRepository,
): CreatePost {

    override fun create(command: CreatePost.Command) {
        Post.create(
            title = Post.Title(command.title),
            contents = Post.Contents(command.contents)
        ).also {
            postRepository.save(it)
        }
    }

}
