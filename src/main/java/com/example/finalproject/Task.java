package com.example.finalproject;

import java.time.LocalDate;

public class Task {
    private static int id_gen = 0;
    private final int task_ID;
    private String name;
    private String description;
    private int duration; // Time estimate in minutes
    private boolean completed;
    private LocalDate dueDate;

    public Task(String name, String description, int duration, LocalDate dueDate) {
        this.task_ID = id_gen;
        id_gen++;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.completed = false;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return name;
    }
}