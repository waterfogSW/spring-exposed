package org.waterfogsw.springexposed.common.exception

class NotFoundException(
    override val message: String,
) : RuntimeException(message)
