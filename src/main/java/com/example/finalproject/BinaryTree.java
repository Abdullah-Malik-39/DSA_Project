package com.example.finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void addTask(Task task, LocalDate dueDate) {
        Node newNode = new Node(task, dueDate);

        if (root == null) {
            root = newNode;
        } else {
            addNode(newNode, root);
        }
    }

    public Node Complete(String name) {
        return search(root, name);
    }

    private Node search(Node node, String name) {
        if (node == null) {
            return null;
        }
        if (node.getTask().getName().equals(name)) {
            node.getTask().setCompleted(true);
            return node;
        }
        Node result = search(node.getLeft(), name);
        if (result != null) {
            return result;
        }
        return search(node.getRight(), name);
    }

    private void addNode(Node newNode, Node current) {
        if (newNode.getDueDate().isBefore(current.getDueDate())) {
            if (current.getLeft() == null) {
                current.setLeft(newNode);
            } else {
                addNode(newNode, current.getLeft());
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(newNode);
            } else {
                addNode(newNode, current.getRight());
            }
        }
    }

    public boolean deleteNode(Task task) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while (current.getTask() != task) {
            parent = current;
            if (task.getDueDate().isBefore(current.getDueDate())) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null) {
                return false;
            }
        }

        // Case 1: Node to be deleted has no children
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
        // Case 2: Node to be deleted has one child
        else if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        }
        // Case 3: Node to be deleted has two children
        else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }

        return true;
    }

    private Node getSuccessor(Node deleteNode) {
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.getRight();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }

        if (successor != deleteNode.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(deleteNode.getRight());
        }

        return successor;
    }

    public void printTree() {
        inOrderTraversal(this.root);
    }

    private void inOrderTraversal(Node current) {
        if (current != null) {
            inOrderTraversal(current.getLeft());
            System.out.println(current.getTask().getName() + " is due on " + current.getDueDate());
            inOrderTraversal(current.getRight());
        }
    }

    public ObservableList<Task> getTree() {
        ObservableList<Task> list = FXCollections.observableArrayList();
        return IOTL(root, list);
    }

    private ObservableList<Task> IOTL(Node current, ObservableList<Task> list) {

        if (current != null) {
            IOTL(current.getLeft(), list);
            list.add(current.getTask());
            IOTL(current.getRight(), list);
        }
        return list;
    }

}