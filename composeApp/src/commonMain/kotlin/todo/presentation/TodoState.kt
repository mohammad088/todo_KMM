package todo.presentation

import todo.domain.entities.Todo

data class TodoState (
    val error : String ="",
    val isLoading : Boolean = false,
    val todos : List<Todo>? = null
)