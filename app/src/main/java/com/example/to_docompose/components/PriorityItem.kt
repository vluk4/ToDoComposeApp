package com.example.to_docompose.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.presentation.theme.LARGE_PADDING
import com.example.to_docompose.presentation.theme.PRIORITY_INDICATOR_SIZE
import com.example.to_docompose.presentation.theme.Typography

@Composable
fun PriorityItem(priority: Priority) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)) {
            drawCircle(color = priority.color)
        }
        Text(
            modifier = Modifier.padding(start = LARGE_PADDING),
            text = priority.name,
            style = Typography.subtitle2 ,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PriorityItemPreview() {
    Column {
        PriorityItem(priority = Priority.HIGH)
        PriorityItem(priority = Priority.MEDIUM)
        PriorityItem(priority = Priority.LOW)
        PriorityItem(priority = Priority.NONE)
    }
}