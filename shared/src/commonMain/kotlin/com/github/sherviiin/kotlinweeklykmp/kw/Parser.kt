package com.github.sherviiin.kotlinweeklykmp.kw

class Parser {

    val regexPattern =
        """<br>\n<a\shref=\"(.*?)\".*>(.*)<\/span><\/strong>.*\n.*>(.*?)<\/span><br>""".toRegex()

    fun parse(input: String): List<Article> {

        val matchResult = regexPattern.findAll(input)

        return matchResult.mapNotNull {
            if (it.groupValues.size < 4) {
                return@mapNotNull null
            }
            Article(
                link = it.groupValues[1],
                title = it.groupValues[2],
                description = it.groupValues[3]
            )
        }.toList()
    }
}

data class Article(
    val link: String,
    val title: String,
    val description: String
)