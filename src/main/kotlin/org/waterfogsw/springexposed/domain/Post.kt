package org.waterfogsw.springexposed.domain

import org.waterfogsw.springexposed.common.entity.DomainEntity
import java.time.LocalDateTime
import java.util.*

data class Post(
    val title: Title,
    val contents: Contents,
    val comments: List<Comment> = emptyList(),

    override val id: UUID = UUID.randomUUID(),
    override val createdAt: LocalDateTime = LocalDateTime.now(),
    override val updatedAt: LocalDateTime = LocalDateTime.now(),
) : DomainEntity {

    @JvmInline
    value class Title(val value: String) {

        init {
            require(value.length in 1..100) {
                "제목은 1자 이상 100자 이하로 입력해 주세요"
            }
        }
    }

    @JvmInline
    value class Contents(val value: String) {

        init {
            require(value.length in 1..1000) {
                "내용은 1자 이상 1000자 이하로 입력해 주세요"
            }
        }
    }

    fun update(
        title: String,
        contents: String,
    ): Post = copy(
        title = Title(title),
        contents = Contents(contents),
        updatedAt = LocalDateTime.now(),
    )

    companion object {

        fun create(
            title: Title,
            contents: Contents,
        ): Post = Post(title, contents)

    }

}
