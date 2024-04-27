package org.waterfogsw.springexposed.domain

import org.waterfogsw.springexposed.common.entity.DomainEntity
import java.time.LocalDateTime
import java.util.*

data class Comment(
    val postId: UUID,
    val contents: Contents,

    override val id: UUID = UUID.randomUUID(),
    override val createdAt: LocalDateTime = LocalDateTime.now(),
    override val updatedAt: LocalDateTime = LocalDateTime.now(),
) : DomainEntity {

    @JvmInline
    value class Contents(val value: String) {

        init {
            require(value.length in 1..1000) {
                "내용은 1자 이상 1000자 이하로 입력해 주세요"
            }
        }
    }


}
