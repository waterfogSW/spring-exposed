package org.waterfogsw.springexposed.application.port.inbound

interface CreatePost {

    fun create(command: Command)

    data class Command(
        val title: String,
        val contents: String,
    )

}
