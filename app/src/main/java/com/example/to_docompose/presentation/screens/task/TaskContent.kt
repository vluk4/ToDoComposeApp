package com.example.to_docompose.presentation.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.components.PriorityDropDown
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.presentation.theme.LARGE_PADDING
import com.example.to_docompose.presentation.theme.MEDIUM_PADDING

@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(LARGE_PADDING)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = {
                onTitleChange(it)
            },
            label = {
                Text(text = stringResource(R.string.title))
            },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )

        Spacer(modifier = Modifier.height(MEDIUM_PADDING))

        PriorityDropDown(
            priority = priority,
            onPrioritySelected = onPrioritySelected
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = {
                Text(text = stringResource(R.string.description))
            },
            textStyle = MaterialTheme.typography.body1
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun TaskContentPreview() {
    TaskContent(
        title = "",
        onTitleChange = {},
        description = "",
        onDescriptionChange = {},
        priority = Priority.HIGH,
        onPrioritySelected = {}
    )
}