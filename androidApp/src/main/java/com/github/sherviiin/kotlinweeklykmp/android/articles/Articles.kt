package com.github.sherviiin.kotlinweeklykmp.android.articles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.sherviiin.kotlinweeklykmp.kw.Article
import com.github.sherviiin.kotlinweeklykmp.android.MyApplicationTheme
import com.github.sherviiin.kotlinweeklykmp.android.openWebPage
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ArticleList(articles: StateFlow<List<Article>>) {
    val context =
        LocalContext.current
    val collectAsState = articles.collectAsState()

    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(collectAsState.value) {
            ArticleItem(it) { context.openWebPage(it.link) }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun ArticleItem(article: Article, callback: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = article.title, fontWeight = FontWeight.Bold)
        Text(text = article.description)
        Text(text = article.link, fontWeight = FontWeight.Thin,
            modifier = Modifier.clickable {
                callback()
            })
    }
}

@Preview
@Composable
private fun ArticleItemPreview() {
    MyApplicationTheme {
        ArticleItem(Article("link", "KMM Rocks!", "desc")) {}
    }
}