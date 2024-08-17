package pe.gusto.gapande.articles

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.gusto.gapande.BaseViewModel

class ArticlesViewModel: BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState())

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            delay(200)

            _articlesState.emit(ArticlesState(error = "Something went wrong"))

            delay(200)

            val fetchedArticles = fetchArticles()

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }
}


private suspend fun fetchArticles(): List<Article> = mockArticles

private val mockArticles = listOf(
    Article(
        "1 - News",
        "desc",
        "2023-11-09",
        "https://images.unsplash.com/photo-1721332149267-ef9b10eaacd9?q=80&w=1336&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ),
    Article(
        "2 - Blog",
        "Desc 2",
        "2023-11-09",
        "https://images.unsplash.com/photo-1720048171527-208cb3e93192?q=80&w=1287&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    ),
    Article(
        "3 - Shorts",
        "desc3",
        "2023-11-09",
        "https://plus.unsplash.com/premium_photo-1723651236737-6b51506acc99?q=80&w=1287&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    ),
)