package com.example.to_docompose.data.repository

import com.example.to_docompose.data.ToDoDao
import com.example.to_docompose.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {

    val getAllTasks: Flow<List<ToDoTask>> = toDoDao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = toDoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTask>> = toDoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<ToDoTask> = toDoDao.getSelectedTask(taskId)

    fun addTask(task: ToDoTask) {
        toDoDao.addTask(task)
    }

    fun updateTask(task: ToDoTask) {
        toDoDao.updateTask(task)
    }

    fun deleteTask(task: ToDoTask) {
        toDoDao.deleteTask(task)
    }

    fun deleteAllTask() {
        toDoDao.deleteAllTask()
    }

    fun searchDatabase(searchQuery: String) = toDoDao.searchDatabase(searchQuery)
}