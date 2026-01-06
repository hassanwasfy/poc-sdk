package com.hwasfy.pocsdk

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform