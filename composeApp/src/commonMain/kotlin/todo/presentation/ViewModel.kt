package todo.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.ViewModelScope
import core.DataState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.kodein.di.instance
import todo.di.KodeinModule
import todo.domain.entities.Todo
import todo.domain.todo_repository.TodoRepository

class TodoViewModel : KMMViewModel() {
 private val _state = mutableStateOf(TodoState())
 val state: State<TodoState> = _state
 private val todoRepository by KodeinModule.todoModule.instance<TodoRepository>()
 init {
     CoroutineScope(Dispatchers.IO).launch {
         todoRepository.getTodos().collect{
             when(it){
                 is DataState.Error -> {
                     _state.value = state.value.copy(
                         error = it.exception.message ?: "Error",
                         isLoading = false
                     )
                 }
                 DataState.Loading -> {
                     _state.value = state.value.copy(
                         isLoading = true
                     )
                 }
                 is DataState.Success -> {
                     _state.value = state.value.copy(
                         todos = it.data,
                         isLoading = false
                     )
                 }
             }
         }
     }
 }
}