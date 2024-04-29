package org.waterfogsw.springexposed.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.waterfogsw.springexposed.application.port.inbound.CreatePost
import org.waterfogsw.springexposed.application.port.inbound.UpdatePost
import org.waterfogsw.springexposed.application.port.outbound.PostRepository
import org.waterfogsw.springexposed.common.exception.NotFoundException
import org.waterfogsw.springexposed.domain.Post
import java.util.*

@Service
@Transactional
class PostCommandService(
    private val postRepository: PostRepository,
) : CreatePost, UpdatePost {

    override fun create(command: CreatePost.Command) {
        Post
            .create(
                title = Post.Title(command.title),
                contents = Post.Contents(command.contents)
            ).also {
                postRepository.save(it)
            }
    }

    override fun updateById(
        id: UUID,
        command: UpdatePost.Command,
    ) {
        val post: Post = postRepository.findById(id)
            ?: throw NotFoundException("해당 게시글을 찾을 수 없습니다.")

        post
            .update(
                title = command.title,
                contents = command.contents
            ).also {
                postRepository.updateById(id, it)
            }
    }

}
