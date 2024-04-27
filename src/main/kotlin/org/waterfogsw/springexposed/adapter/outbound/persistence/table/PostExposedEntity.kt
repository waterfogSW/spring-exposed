package org.waterfogsw.springexposed.adapter.outbound.persistence.table

import kotlinx.datetime.toJavaLocalDateTime
import kotlinx.datetime.toKotlinLocalDateTime
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.waterfogsw.springexposed.domain.Post
import java.util.UUID

class PostExposedEntity(
    id: EntityID<UUID>
) : UUIDEntity(id) {
    var title by PostTable.title

    var contents by PostTable.contents
    var createdAt by PostTable.createdAt
    var updatedAt by PostTable.updatedAt
    fun toDomain() = Post(
        id = this.id.value,
        title = Post.Title(this.title),
        contents = Post.Contents(this.contents),
        createdAt = this.createdAt.toJavaLocalDateTime(),
        updatedAt = this.updatedAt.toJavaLocalDateTime()
    )

    companion object : UUIDEntityClass<PostExposedEntity>(PostTable) {
        fun toExposedEntity(post: Post) = PostExposedEntity.new {
            title = post.title.value
            contents = post.contents.value
            createdAt = post.createdAt.toKotlinLocalDateTime()
            updatedAt = post.updatedAt.toKotlinLocalDateTime()
        }
    }
}
