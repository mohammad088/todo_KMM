package todo.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import todo.domain.entities.Todo

@Composable
fun TodoItem(todo: Todo) {
    Card(
        contentColor = Color.Gray,
        elevation = 5.dp,
        modifier = Modifier
            .padding(10.dp)
            .border(width = 3.dp , color = Color.Green , shape = RoundedCornerShape(25))
            .clip(RoundedCornerShape(25))
            .height(100.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Text(todo.id.toString() , fontSize = 10.sp , fontWeight = FontWeight.SemiBold , color = Color.DarkGray)
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(todo.title, fontSize = 15.sp  , fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.size(10.dp))
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            shape = CircleShape,
                            color = if (todo.completed) Color.Green else Color.Red
                        )
                )
            }
        }

    }
}