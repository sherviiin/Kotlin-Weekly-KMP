package com.github.sherviiin.kotlinweeklykmp.android

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.github.sherviiin.kotlinweeklykmp.android.articles.ArticleList
import com.github.sherviiin.kotlinweeklykmp.kw.Article
import com.github.sherviiin.kotlinweeklykmp.kw.KotlinWeeklyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val articleFlow = MutableStateFlow<List<Article>>(emptyList())
        val kotlinWeeklyRepository = KotlinWeeklyRepository()
        lifecycleScope.launch {
            val articles = kotlinWeeklyRepository.getArticles()
            articleFlow.emit(articles)
        }


        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArticleList(articleFlow)
                }
            }
        }
    }
}

fun Context.openWebPage(url: String) {
    val webpage = Uri.parse(url)
    val intent = Intent(Intent.ACTION_VIEW, webpage)
    startActivity(intent)
}
