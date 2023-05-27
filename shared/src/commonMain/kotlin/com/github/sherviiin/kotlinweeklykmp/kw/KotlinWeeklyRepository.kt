package com.github.sherviiin.kotlinweeklykmp.kw

import com.github.sherviiin.kotlinweeklykmp.network.getArticlesRaw

class KotlinWeeklyRepository {

    private val parser = Parser()

    suspend fun getArticles(): List<Article> {
        return parser.parse(getArticlesRaw())
    }
}