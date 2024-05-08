package todo.domain.todo_repository

import core.DataState
import kotlinx.coroutines.flow.Flow
import todo.domain.entities.Todo

interface TodoRepository {
    suspend fun getTodos() : Flow<DataState<List<Todo>>>
}