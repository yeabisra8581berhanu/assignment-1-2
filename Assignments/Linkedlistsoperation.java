class Node {
    int data;
    Node next;

    // Constructor to initialize a node with data
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListOperations {
    private Node head;

    // Method to insert a node at a specified position in the linked list
    public void insertAtPosition(int position, int data) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = head;
            for (int i = 1; i < position - 1 && previous != null; i++) {
                previous = previous.next;
            }
            if (previous == null) {
                System.out.println("Invalid position");
                return;
            }
            newNode.next = previous.next;
            previous.next = newNode;
        }
    }

    // Method to delete a node at a specified position in the linked list
    public void deleteAtPosition(int position) {
        if (head == null) {
            return;
        }
        if (position == 1) {
            head = head.next;
        } else {
            Node previous = head;
            for (int i = 1; i < position - 1 && previous != null; i++) {
                previous = previous.next;
            }
            if (previous == null || previous.next == null) {
                System.out.println("Invalid position");
                return;
            }
            previous.next = previous.next.next;
        }
    }

    // Method to delete the node after a given node in the linked list
    public void deleteAfterNode(Node prevNode) {
        if (prevNode == null || prevNode.next == null) {
            System.out.println("Invalid previous node");
            return;
        }
        prevNode.next = prevNode.next.next;
    }

    // Method to search for a node with a specific value in the linked list
    public boolean searchNode(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    // Method to push an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Method to pop an element from the stack
    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    // Method to peek the top element of the stack
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}

public class Linkedlistsoperation {
    public static void main(String[] args) {
        // Create a linked list operations object
        LinkedListOperations listOps = new LinkedListOperations();

        // Insert nodes at specific positions
        listOps.insertAtPosition(1, 10);
        listOps.insertAtPosition(2, 20);
        listOps.insertAtPosition(3, 30);
        listOps.insertAtPosition(4, 40);

        // Delete node at a specific position
        listOps.deleteAtPosition(2);

        // Search for a node with a specific value
        System.out.println("Is 20 present in the linked list? " + listOps.searchNode(20));

        // Create a stack object
        Stack stack = new Stack();

        // Push elements onto the stack
        stack.push(50);
        stack.push(60);
        stack.push(70);

        // Pop an element from the stack
        System.out.println("Popped element from stack: " + stack.pop());

        // Peek the top element of the stack
        System.out.println("Top element of stack: " + stack.peek());
    }
}
