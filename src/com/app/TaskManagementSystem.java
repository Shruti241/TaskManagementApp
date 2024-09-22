package com.app;

import com.service.TaskService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        do {
            try {
                System.out.println("Task Management System:");
                System.out.println("1. Create Task");
                System.out.println("2. Update Task");
                System.out.println("3. Add SubTask to Task");
                System.out.println("4. View All Tasks");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (option) {
                    case 1:
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter task deadline (YYYY-MM-DD): ");
                        LocalDate deadline = LocalDate.parse(scanner.nextLine());
                        System.out.print("Enter assigned user: ");
                        String assignedUser = scanner.nextLine();
                        taskService.createTask(description, deadline, assignedUser);
                        System.out.println("Task created successfully!");
                        break;

                    case 2:
                        System.out.print("Enter task ID to update: ");
                        int taskId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new description: ");
                        String newDescription = scanner.nextLine();
                        System.out.print("Enter new deadline (YYYY-MM-DD): ");
                        LocalDate newDeadline = LocalDate.parse(scanner.nextLine());
                        System.out.print("Enter new assigned user: ");
                        String newAssignedUser = scanner.nextLine();
                        System.out.print("Enter new status (open/closed): ");
                        String newStatus = scanner.nextLine();
                        taskService.updateTask(taskId, newDescription, newDeadline, newAssignedUser, newStatus);
                        break;

                    case 3:
                        System.out.print("Enter task ID to add subtask: ");
                        int parentTaskId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter subtask description: ");
                        String subDescription = scanner.nextLine();
                        System.out.print("Enter subtask deadline (YYYY-MM-DD): ");
                        LocalDate subDeadline = LocalDate.parse(scanner.nextLine());
                        System.out.print("Enter assigned user for subtask: ");
                        String subAssignedUser = scanner.nextLine();
                        taskService.addSubTask(parentTaskId, subDescription, subDeadline, subAssignedUser);
                        System.out.println("SubTask added successfully!");
                        break;

                    case 4:
                        taskService.viewAllTasks();
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

        } while (option != 0);

        scanner.close();
    }
}