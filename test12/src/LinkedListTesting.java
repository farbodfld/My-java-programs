import java.util.LinkedList;

public class LinkedListTesting {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node current = head;
        for (int i = 1; i <= 10; i++) {
            current.next = new Node(i);
            current = current.next;
        }

        Node node2 = head;
        while (node2 != null) {
            System.out.print(node2.data + "->");
            node2 = node2.next;
        }
    }
}


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}