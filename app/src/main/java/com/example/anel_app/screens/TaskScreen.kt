package com.example.anel_app.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.anel_app.components.AddTaskInput
import com.example.anel_app.components.TaskAppTopBar
import com.example.anel_app.components.TaskCard
import com.example.anel_app.components.TaskItem
import com.example.anel_app.ui.theme.backgroundColor
import com.example.anel_app.view_models.TaskViewModel


class TaskScreen {
    @Composable
    fun TaskScreen(viewModel: TaskViewModel) {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                Text("Hello, world!")
            }
        }
    }
    @Preview
    @Composable
    fun TaskScreenPreview() {
        MyTestApplicationTheme {
            TaskScreen(viewModel = TaskViewModel())
        }
    }

    @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
    @Composable
    fun DarkTaskScreenPreview() {
        MyTestApplicationTheme {
            TaskScreen(viewModel = TaskViewModel())
        }
    }

    Scaffold(
    topBar = {
        TaskAppTopBar(deleteAllTasksDialog, isInputVisible)
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.backgroundColor)
                .fillMaxSize()
                .padding(paddingValues)
                .imePadding(),
        ) {
            // Call our extension function and place the AddTaskInput component inside the content block
            isInputVisible.ExpandAndShrinkAnimation {
                AddTaskInput(viewModel)
            }
            LazyColumn(
                modifier = Modifier.weight(1f),
                content = {
                    items(items = viewModel.taskList, key = {
                        it.id
                    }) { task ->
                        TaskItem(viewModel, task)
                    }
                })
        }
    }



