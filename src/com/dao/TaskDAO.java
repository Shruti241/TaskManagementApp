package com.dao;

//public class TaskDAO {
//}
import com.model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private List<Task> tasks = new ArrayList<>();
    private int taskIdCounter = 1;
    private int subTaskIdCounter = 1;

    // Create a new task
    public Task createTask(String description, LocalDate deadline, String assignedUser) {
        Task newTask = new Task(taskIdCounter++, description, deadline, assignedUser);
        tasks.add(newTask);
        return newTask;
    }

    // Update an existing task
    public Task updateTask(int taskId, String newDescription, LocalDate newDeadline, String newAssignedUser, String newStatus) throws Exception {
        Task task = findTaskById(taskId);
        if (task == null) {
            throw new Exception("Task with ID " + taskId + " not found.");
        }
        task.setDescription(newDescription);
        task.setDeadline(newDeadline);
        task.setAssignedUser(newAssignedUser);
        task.setStatus(newStatus);
        return task;
    }

    // Add a subtask to an existing task
    public Task.SubTask addSubTaskToTask(int taskId, String description, LocalDate deadline, String assignedUser) throws Exception {
        Task task = findTaskById(taskId);
        if (task == null) {
            throw new Exception("Task with ID " + taskId + " not found.");
        }
        Task.SubTask newSubTask = new Task.SubTask(subTaskIdCounter++, description, deadline, assignedUser);
        task.addSubTask(newSubTask);
        return newSubTask;
    }

    // Find a task by ID
    private Task findTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return tasks;
    }
}

