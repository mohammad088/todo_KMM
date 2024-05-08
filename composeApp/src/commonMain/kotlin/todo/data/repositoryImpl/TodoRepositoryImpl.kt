package todo.data.repositoryImpl

import core.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.kodein.di.DI
import org.kodein.di.instance
import todo.data.remote_datasource.TodoRemoteDataSource
import todo.domain.entities.Todo
import todo.domain.todo_repository.TodoRepository

class TodoRepositoryImpl(
    private val di : DI
) : TodoRepository {
    private val todoRemoteDataSource : TodoRemoteDataSource by di.instance()
    override suspend fun getTodos(): Flow<DataState<List<Todo>>> = flow{
        try {
            emit(DataState.Loading)
            val todos = todoRemoteDataSource.getTodos()
            emit(DataState.Success(todos))
        }catch (e:Exception){
            emit(DataState.Error(e))
        }
    }
}