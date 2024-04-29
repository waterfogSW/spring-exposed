package org.waterfogsw.springexposed.application.port.inbound

import java.util.*

interface DeletePost {

    fun deleteById(id: UUID)

}
