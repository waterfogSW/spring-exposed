package org.waterfogsw.springexposed.adapter.outbound.persistence.table

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.datetime

object PostTable : UUIDTable("posts") {

    val title = varchar("title", 100)
    val contents = text("contents")
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
}
