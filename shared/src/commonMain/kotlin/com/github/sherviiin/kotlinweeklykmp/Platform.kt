package com.github.sherviiin.kotlinweeklykmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform