import java.util.Stack;

public class LinkedList {
    Node head;  // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /********************************************************************/
    class FIFO {
        Node front, rear;

        void enQueue(int x) {
            Node temp = new Node(x);

            if (rear == null) {
                front = rear = temp;
                return;
            }

            rear.next = temp;
            rear = temp;
        }

        void deQueue() {
            if (front == null)
                return;
            Node temp = front;
            front = front.next;

            if (front == null)
                rear = null;
        }
    }

    /********************************************************************/
    void removeDuplicates() {
        /*Set another reference to head*/
        Node curr = head;

        /* Traverse list till the last node */
        while (curr != null) {
            Node temp = curr;
            /*Compare current node with the next node and
            keep on deleting them until it matches the current
            node data */
            while (temp != null && temp.data == curr.data) {
                temp = temp.next;
            }
            /*Set current node next to the next different
            element denoted by temp*/
            curr.next = temp;
            curr = curr.next;
        }
    }

    /********************************************************************/
    Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;

        /* reverse the rest list and put
        the first element at the end */
        Node rest = reverse(head.next);
        head.next.next = head;

        /* tricky step -- see the diagram */
        head.next = null;

        /* fix the head pointer */
        return rest;
    }

    /********************************************************************/
    void Split_LinkedList(Node head) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList1 = new LinkedList();

        if (head == null)
            return;
        Split_LinkedList(head.next);
        int count = 0;
        if ((count++) % 2 == 0) {
            // insert(linkedList , head.data);
        } else {
            //insert(linkedList1 , head.data);
        }

    }

    /********************************************************************/
    boolean isIntersection(Node node1, Node node2) {
        Node current1 = node1;
        Node current2 = node2;
        while (current1 != null && current2 != null) {
            if (current1.data == current2.data)
                return true;
            current1 = current1.next;
            current2 = current2.next;
        }
        return false;
    }

    /********************************************************************/
    int countNodes(Node n) {
        int res = 1;
        Node temp = n;
        while (temp.next != n) {
            res++;
            temp = temp.next;
        }
        return res;
    }

    /********************************************************************/
    /* This function detects and counts loop
    nodes in the list. If loop is not there
    in then returns 0 */

    int countNodesInLoop(Node list) {
        Node slow_p = list, fast_p = list;

        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;

        /* If slow_p and fast_p meet at some point
        then there is a loop */
            if (slow_p == fast_p)
                return countNodes(slow_p);
        }

        /* Return 0 to indeciate that ther is no loop*/
        return 0;
    }

    /********************************************************************/
    Node deleteMid(Node head) {
        // Base cases
        if (head == null)
            return null;
        if (head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        // to reach middle of linked list
        Node slow_ptr = head;
        Node fast_ptr = head;

        // Find the middle and previous of middle.
        Node prev = null;

        // To store previous of slow_ptr
        while (fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            prev = slow_ptr;
            slow_ptr = slow_ptr.next;
        }

        // Delete the middle node
        prev.next = slow_ptr.next;

        return head;
    }

    /********************************************************************/
    Node deleteNode(Node start) {
        int counter = 0;
        while (start.next != null) {
            counter++;
            start = start.next;
        }

        int k = counter / 2;
        // If invalid k
        if (k < 1)
            return start;

        // Base case (start needs to be deleted)
        if (k == 1) {
            Node res = start.next;
            return res;
        }

        start.next = deleteNode(start.next);
        return start;
    }

    /********************************************************************/
    Node sortedMerge(Node a, Node b) {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    // Utility function to get the middle of the linked list
    Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Node mergeSort(Node h) {    // Time Complexity: O(n Log n)
        // Base case : if head is null
        if (h == null || h.next == null) {
            return h;
        }

        // get the middle of the list
        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        Node left = mergeSort(h);

        // Apply mergeSort on right list
        Node right = mergeSort(nextOfMiddle);

        // Merge the left and right lists
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    /********************************************************************/
    /*Function to check if given linked list is
      palindrome or not by using Stack*/

    boolean IsPalindrome(Node head) {
        // This pointer will allow the first traversal
        // of the linked list
        Node current = head;

        boolean ispalin = true;
        Stack<Integer> stack = new Stack<Integer>();

        // Traverse the linked list and add its elements
        // to the stack
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }
        // Iterate the linked list again and
        // check by each element with the stack
        while (head != null) {
            int i = stack.pop();
            if (head.data == i) {
                ispalin = true;
            } else {
                ispalin = false;
                break;
            }
            // Move to the current element in stack and the list
            head = head.next;
        }
        return ispalin;
    }

    /********************************************************************/
    /* Function to check if given linked list is
       palindrome or not by reversing the list  */
    boolean isPalindrome(Node head) {
        Node slow_ptr = head;
        Node fast_ptr = head;
        Node prev_of_slow_ptr = head;
        Node midnode = null; // To handle odd size list
        boolean res = true; // initialize result

        if (head != null && head.next != null) {
            /* Get the middle of the list. Move slow_ptr by 1
               and fast_ptrr by 2, slow_ptr will have the middle
               node */
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;

                /*We need previous of the slow_ptr for
                  linked lists  with odd elements */
                prev_of_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
            }

            /* fast_ptr would become NULL when there are even elements
               in the list and not NULL for odd elements. We need to skip
               the middle node for odd case and store it somewhere so that
               we can restore the original list */
            if (fast_ptr != null) {
                midnode = slow_ptr;
                slow_ptr = slow_ptr.next;
            }

            // Now reverse the second half and compare it with first half
            Node second_half = slow_ptr;
            prev_of_slow_ptr.next = null; // NULL terminate first half
            reverse(head); // Reverse the second half
            res = compareLists(head, second_half); // compare

            /* Construct the original list back */
            reverse(head); // Reverse the second half again

            if (midnode != null) {
                // If there was a mid node (odd size case) which
                // was not part of either first half or second half.
                prev_of_slow_ptr.next = midnode;
                midnode.next = second_half;
            } else
                prev_of_slow_ptr.next = second_half;
        }
        return res;
    }

    /* Function to check if two input lists have same data*/
    boolean compareLists(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else
                return false;
        }

        /* Both are empty reurn 1*/
        if (temp1 == null && temp2 == null)
            return true;

        /* Will reach here when one is NULL
           and other is not */
        return false;
    }

    /********************************************************************/
    /*Function for checking doubly LinkedList
      is Palindrome or not*/

    boolean isPalindrome_Doubly(Node left) {
        if (left == null)
            return true;

        // Find rightmost node
        Node right = left;
        while (right.next != null)
            right = right.next;

        while (left != right) {
            if (left.data != right.data)
                return false;

            left = left.next;
            right = right.prev;
        }

        return true;
    }

    /********************************************************************/
    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /********************************************************************/
    void push(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    /********************************************************************/
    public boolean add(Integer element) {
        Node new_node = new Node(element);
        if (head == null) {
            head = new Node(element);
            return false;
        }
        new_node.next = null;
        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = new_node;
        return true;
    }

    /********************************************************************/
    public void add(int index, Integer element) {
        if (index < 0 || index > size()) {
            // throw new IndexOutOfBoundsException();
            return;
        }
        if (index == size()) {
            add(element);
            return;
        } else if (index == 0) {
            // head = new Node(element,head);
            Node newnode = new Node(element);
            newnode.next = head.next;
            head.next = newnode;
        } else {
            Node courent = head;
            for (int j = 0; j < index; j++) {
                courent = courent.next;
            }
            Node new_node = new Node(element);
            new_node.next = courent.next;
            courent.next = new_node;
        }
    }

    /********************************************************************/
    public void addFirst(int element) {
        Node new_node = new Node(element);
        new_node.next = head;
        head = new_node;
    }

    /********************************************************************/
    public void addLast(Integer element) {
        Node new_node = new Node(element);
        if (head == null) {
            head = new Node(element);
        } else {
            new_node.next = null;
            Node last = head;
            while (last.next != null)
                last = last.next;
            last.next = new_node;
        }
    }

    /********************************************************************/
    public void clear() {
        head = null;
    }

    /********************************************************************/
    public boolean contains(Integer i) {
        Node courent = head;
        while (courent != null) {
            if (courent.equals(i)) {
                return true;
            }
            courent = courent.next;
        }
        return false;
    }

    /********************************************************************/
    public Integer get(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        return current.data;
    }

    /********************************************************************/
    public int indexOf(Integer i) {
        Node courent = head;
        int index = 0;
        while (courent != null) {
            if (courent.data == i) {
                return index;
            }
            index++;
            courent = courent.next;
        }
        return -1;
    }

    /********************************************************************/
    public void remove() {
        if (head == null) {
            return;
        }
        Node temp = head;
        head = head.next;
        // temp = null;
    }

    /********************************************************************/
    public Integer remove(int index) {
        int a = 0;
        if (index >= 0 && index < size()) {
            Node courent = head;
            for (int i = 0; i < index; i++) {
                courent = courent.next;
            }
            a = courent.data;
            Node temp = courent;
            courent = courent.next;
            // temp = null;
        }
        return a;
    }

    /********************************************************************/
    public int size() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /********************************************************************/
    public Integer[] toArray() {
        Node courent = head;
        Integer[] array = new Integer[size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = courent.data;
            courent = courent.next;
        }
        return array;
        // LinkedList<Integer> linkedlist = new LinkedList<>();
        // Integer[] array = linkedlist.toArray(new Integer[linkedlist.size()]);
        //  return array;
    }

    /********************************************************************/
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }


    /* Driver program to test above function*/
    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.push(60);
        list.push(20);
        list.push(10);
        list.push(40);

        LinkedList list1 = new LinkedList();
        list1.push(1);
        list1.push(10);
        list1.push(15);

       /* list.removeDuplicates();
        list.print();

        list.head = list.reverse(list.head);
        list.print();

       System.out.println(list.isIntersection(list.head , list1.head));

       list.countNodesInLoop(list.head);

       list.deleteMid(list.head);

       list.mergeSort(list.head);

      list.head = list.mergeSort(list.head);
      list.print();*/
    }
}
