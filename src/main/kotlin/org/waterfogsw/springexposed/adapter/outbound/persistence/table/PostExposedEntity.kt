package org.waterfogsw.springexposed.adapter.outbound.persistence.table

import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.waterfogsw.springexposed.domain.Post
import java.util.*

class PostExposedEntity(
    id: EntityID<UUID>,
) : UUIDEntity(id) {

    var title by PostTable.title

    var contents by PostTable.contents
    var createdAt by PostTable.createdAt
    var updatedAt by PostTable.updatedAt

    fun toDomain() = Post(
        id = this.id.value,
        title = Post.Title(this.title),
        contents = Post.Contents(this.contents),
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )

    companion object : UUIDEntityClass<PostExposedEntity>(PostTable) {

        fun toExposedEntity(post: Post) = PostExposedEntity.new {
            title = post.title.value
            contents = post.contents.value
            createdAt = post.createdAt
            updatedAt = post.updatedAt
        }
    }
}
