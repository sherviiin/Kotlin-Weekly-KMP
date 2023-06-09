package com.github.sherviiin.kotlinweeklykmp.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

val client = HttpClient()
private const val KOTLIN_WEEKLY_RSS_FEED_URL =
    "https://us12.campaign-archive.com/feed?u=f39692e245b94f7fb693b6d82&id=93b2272cb6"

suspend fun getArticlesRaw(): String {
    return client.get(KOTLIN_WEEKLY_RSS_FEED_URL)
        .bodyAsText()
}