package todo.di

import io.ktor.client.HttpClient
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.provider
import org.kodein.di.singleton
import todo.data.remote_datasource.TodoRemoteDataSource
import todo.data.remote_datasource.TodoRemoteDataSourceImpl
import todo.data.repositoryImpl.TodoRepositoryImpl
import todo.domain.todo_repository.TodoRepository
import todo.presentation.TodoViewModel

object KodeinModule {
    val todoModule = DI {
        bind<TodoRemoteDataSource>() with provider { TodoRemoteDataSourceImpl(di) }
        bind<TodoRepository>() with provider { TodoRepositoryImpl(di) }
        bind<HttpClient>() with singleton { HttpClient()}
    }
}