import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview
import todo.presentation.TodoViewModel
import todo.presentation.TodoItem


@Composable
@Preview
fun App() {
    val viewModel = remember { TodoViewModel() }
    viewModel.state.value.todos?.let {
        todos ->
        LazyColumn {
            items(todos){
                todo ->
                TodoItem(todo)
            }
        }
    }
    if(viewModel.state.value.isLoading){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            CircularProgressIndicator(
                color = Color.Green
            )
        }
    }
    if(viewModel.state.value.error.isNotEmpty()){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Text(
                "Connection Error"
            )
        }
    }
}