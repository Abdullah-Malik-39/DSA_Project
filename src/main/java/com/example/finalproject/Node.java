package com.example.finalproject;

import java.time.LocalDate;

public class Node {
    private Task task;
    private LocalDate dueDate;
    private Node left;
    private Node right;

    public Node(Task task, LocalDate dueDate) {
        this.task = task;
        this.dueDate = dueDate;
        this.left = null;
        this.right = null;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}