package org.waterfogsw.springexposed.common.entity

import java.time.LocalDateTime
import java.util.*

interface DomainEntity {

    val id: UUID
    val createdAt: LocalDateTime
    val updatedAt: LocalDateTime

}
