package com.service;

//public class TaskService {
//}
import com.dao.TaskDAO;
import com.model.Task;

import java.time.LocalDate;

public class TaskService {
    private TaskDAO taskDAO = new TaskDAO();

    // Create a new task
    public Task createTask(String description, LocalDate deadline, String assignedUser) {
        return taskDAO.createTask(description, deadline, assignedUser);
    }

    // Update an existing task
    public Task updateTask(int taskId, String newDescription, LocalDate newDeadline, String newAssignedUser, String newStatus) {
        try {
            return taskDAO.updateTask(taskId, newDescription, newDeadline, newAssignedUser, newStatus);
        } catch (Exception e) {
            System.out.println("Error updating task: " + e.getMessage());
            return null;
        }
    }

    // Add a new subtask to a task
    public Task.SubTask addSubTask(int taskId, String description, LocalDate deadline, String assignedUser) {
        try {
            return taskDAO.addSubTaskToTask(taskId, description, deadline, assignedUser);
        } catch (Exception e) {
            System.out.println("Error adding subtask: " + e.getMessage());
            return null;
        }
    }

    // Get all tasks
    public void viewAllTasks() {
        if (taskDAO.getAllTasks().isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (Task task : taskDAO.getAllTasks()) {
            System.out.println("Task ID: " + task.getId());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Deadline: " + task.getDeadline());
            System.out.println("Assigned User: " + task.getAssignedUser());
            System.out.println("Status: " + task.getStatus());

            if (!task.getSubTasks().isEmpty()) {
                System.out.println("Subtasks:");
                for (Task.SubTask subTask : task.getSubTasks()) {
                    System.out.println("  SubTask ID: " + subTask.getId());
                    System.out.println("  Description: " + subTask.getDescription());
                    System.out.println("  Deadline: " + subTask.getDeadline());
                    System.out.println("  Assigned User: " + subTask.getAssignedUser());
                    System.out.println("  Status: " + subTask.getStatus());
                }
            }
            System.out.println();
        }
    }
}


