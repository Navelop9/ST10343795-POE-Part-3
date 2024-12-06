/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

/**
 *
 * @author Phathutshedzo Lukoto
 */
public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, 
                String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    private String createTaskID() {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" +
               developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\nDeveloper Details: " + developerDetails +
               "\nTask Number: " + taskNumber + "\nTask Name: " + taskName +
               "\nTask Description: " + taskDescription + "\nTask ID: " + taskID +
               "\nTask Duration: " + taskDuration + " hours";
    }

    public int getTaskDuration() {
        return taskDuration;
    }
}
