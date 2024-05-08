package todo.data.remote_datasource

import core.URL
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.Url
import io.ktor.http.contentType
import kotlinx.serialization.json.Json
import org.kodein.di.DI
import todo.domain.entities.Todo



interface TodoRemoteDataSource {
    suspend fun getTodos(): List<Todo>
}

class  TodoRemoteDataSourceImpl(private val di : DI) : TodoRemoteDataSource{
    override suspend fun getTodos(): List<Todo> {
        val client = HttpClient()
        val response = client.get("https://jsonplaceholder.typicode.com/todos")
        val todos = Json.decodeFromString<List<Todo>>(response.bodyAsText())
        return todos
    }

}