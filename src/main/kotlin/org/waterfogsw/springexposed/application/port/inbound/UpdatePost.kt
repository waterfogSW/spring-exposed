package org.waterfogsw.springexposed.application.port.inbound

import java.util.*

interface UpdatePost {

    fun updateById(
        id: UUID,
        command: Command,
    )

    data class Command(
        val title: String,
        val contents: String,
    )

}
