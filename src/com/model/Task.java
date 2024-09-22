package com.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private int id;
    private String description;
    private LocalDate deadline;
    private String assignedUser;
    private String status; // "open" or "closed"
    private List<SubTask> subTasks;

    public Task(int id, String description, LocalDate deadline, String assignedUser) {
        this.id = id;
        this.description = description;
        this.deadline = deadline;
        this.assignedUser = assignedUser;
        this.status = "open"; // Default status
        this.subTasks = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void addSubTask(SubTask subTask) {
        subTasks.add(subTask);
    }

    // Nested SubTask class
    public static class SubTask {
        private int id;
        private String description;
        private LocalDate deadline;
        private String assignedUser;
        private String status; // "open" or "closed"

        public SubTask(int id, String description, LocalDate deadline, String assignedUser) {
            this.id = id;
            this.description = description;
            this.deadline = deadline;
            this.assignedUser = assignedUser;
            this.status = "open"; // Default status
        }

        // Getters and Setters
        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public LocalDate getDeadline() {
            return deadline;
        }

        public void setDeadline(LocalDate deadline) {
            this.deadline = deadline;
        }

        public String getAssignedUser() {
            return assignedUser;
        }

        public void setAssignedUser(String assignedUser) {
            this.assignedUser = assignedUser;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
