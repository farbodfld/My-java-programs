// Java program for insertion and
// deletion in Circular Queue
import java.util.ArrayList;
import java.util.*;

class CircularQueue{

    // Declaring the class variables.
    private int size, front, rear;

    // Declaring array list of integer type.
    private ArrayList<Integer> queue = new ArrayList<Integer>();

    // Constructor
    CircularQueue(int size)
    {
        this.size = size;
        this.front = this.rear = -1;
    }

    // Method to insert a new element in the queue.
    public void enQueue(int data)
    {

        // Condition if queue is full.
        if((front == 0 && rear == size - 1) ||
                (rear == (front - 1) % (size - 1)))
        {
            System.out.print("Queue is Full");
        }

        // condition for empty queue.
        else if(front == -1)
        {
            front = 0;
            rear = 0;
            queue.add(rear, data);
        }

        else if(rear == size - 1 && front != 0)
        {
            rear = 0;
            queue.set(rear, data);
        }

        else
        {
            rear = (rear + 1);

            // Adding a new element if
            if(front <= rear)
            {
                queue.add(rear, data);
            }

            // Else updating old value
            else
            {
                queue.set(rear, data);
            }
        }
    }

    // Function to dequeue an element
// form th queue.
    public int deQueue()
    {
        int temp;

        // Condition for empty queue.
        if(front == -1)
        {
            System.out.print("Queue is Empty");

            // Return -1 in case of empty queue
            return -1;
        }

        temp = queue.get(front);

        // Condition for only one element
        if(front == rear)
        {
            front = -1;
            rear = -1;
        }

        else if(front == size - 1)
        {
            front = 0;
        }
        else
        {
            front = front + 1;
        }

        // Returns the dequeued element
        return temp;
    }

    // Method to display the elements of queue
    public void displayQueue()
    {

        // Condition for empty queue.
        if(front == -1)
        {
            System.out.print("Queue is Empty");
            return;
        }

        // If rear has not crossed the max size
        // or queue rear is still greater then
        // front.
        System.out.print("Elements in the " +
                "circular queue are: ");

        if(rear >= front)
        {

            // Loop to print elements from
            // front to rear.
            for(int i = front; i <= rear; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }

        // If rear crossed the max index and
        // indexing has started in loop
        else
        {

            // Loop for printing elements from
            // front to max size or last index
            for(int i = front; i < size; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }

            // Loop for printing elements from
            // 0th index till rear position
            for(int i = 0; i <= rear; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args)
    {

        // Initialising new object of
        // CircularQueue class.
        CircularQueue q = new CircularQueue(5);

        q.enQueue(14);
        q.enQueue(22);
        q.enQueue(13);
        q.enQueue(-6);

        q.displayQueue();

        int x = q.deQueue();

        // Checking for empty queue.
        if(x != -1)
        {
            System.out.print("Deleted value = ");
            System.out.println(x);
        }

        x = q.deQueue();

        // Checking for empty queue.
        if(x != -1)
        {
            System.out.print("Deleted value = ");
            System.out.println(x);
        }

        q.displayQueue();

        q.enQueue(9);
        q.enQueue(20);
        q.enQueue(5);

        q.displayQueue();

        q.enQueue(20);
    }
}
/**************************************************************************************/
// Java program for insertion and
// deletion in Circular Queue


class Solution {

    // Structure of a Node
    static class Node {
        int data;
        Node link;
    }

    static class Queue {
        Node front, rear;
    }

    // Function to create Circular queue
    static void enQueue(Queue q, int value)
    {
        Node temp = new Node();
        temp.data = value;
        if (q.front == null)
            q.front = temp;
        else
            q.rear.link = temp;

        q.rear = temp;
        q.rear.link = q.front;
    }

    // Function to delete element from Circular Queue
    static int deQueue(Queue q)
    {
        if (q.front == null) {
            System.out.printf("Queue is empty");
            return Integer.MIN_VALUE;
        }

        // If this is the last node to be deleted
        int value; // Value to be dequeued
        if (q.front == q.rear) {
            value = q.front.data;
            q.front = null;
            q.rear = null;
        }
        else // There are more than one nodes
        {
            Node temp = q.front;
            value = temp.data;
            q.front = q.front.link;
            q.rear.link = q.front;
        }

        return value;
    }

    // Function displaying the elements of Circular Queue
    static void displayQueue(Queue q)
    {
        Node temp = q.front;
        System.out.printf("\nElements in Circular Queue are: ");
        while (temp.link != q.front) {
            System.out.printf("%d ", temp.data);
            temp = temp.link;
        }
        System.out.printf("%d", temp.data);
    }

    /* Driver of the program */
    public static void main(String args[])
    {
        // Create a queue and initialize front and rear
        Queue q = new Queue();
        q.front = q.rear = null;

        // Inserting elements in Circular Queue
        enQueue(q, 14);
        enQueue(q, 22);
        enQueue(q, 6);

        // Display elements present in Circular Queue
        displayQueue(q);

        // Deleting elements from Circular Queue
        System.out.printf("\nDeleted value = %d", deQueue(q));
        System.out.printf("\nDeleted value = %d", deQueue(q));

        // Remaining elements in Circular Queue
        displayQueue(q);

        enQueue(q, 9);
        enQueue(q, 20);
        displayQueue(q);
    }
}

// This code is contributed
// by Arnab Kundu

