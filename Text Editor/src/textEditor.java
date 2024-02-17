import java.util.Scanner;

public class textEditor {
    public String Editor(String inputString) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        char[] charInputString = new char[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            charInputString[i] = inputString.charAt(i);
        }

        for (int i = 0; i < charInputString.length; i++) {
            if (charInputString[i] != '<' && charInputString[i] != '>' && charInputString[i] != '-')
                stack1.push(charInputString[i]);

            else if (charInputString[i] == '<') {
                if (!stack1.isEmpty())
                    stack2.push(stack1.pop());

            } else if (charInputString[i] == '>') {
                if (!stack2.isEmpty())
                    stack1.push(stack2.pop());

            } else if (charInputString[i] == '-') {
                if (!stack1.isEmpty())
                    stack1.pop();
            }
        }

        while (!stack2.isEmpty())
            stack1.push(stack2.pop());

        while (!stack1.isEmpty())
            stack2.push(stack1.pop());

        String result = stack2.display();

        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        textEditor textEditor = new textEditor();
        textEditor.Editor(s);
    }
}

class Stack {
    static final int MAX = 1000;
    int top;
    char a[] = new char[MAX]; // Maximum size of Stack

    boolean isEmpty() {
        return (top < 0);
    }

    Stack() {
        top = -1;
    }

    void push(char x) {
        if (top >= (MAX - 1)) {
        } else {
            a[++top] = x;
        }
    }

    char pop() {
        if (top < 0) {
            return 0;
        } else {
            char x = a[top--];
            return x;
        }
    }

    char peek() {
        if (top < 0) {
            return 0;
        } else {
            char x = a[top];
            return x;
        }
    }

    String display() {
        if (isEmpty())
            System.out.println("-1");
        else
            for (int i = top; i >= 0; i--)
                System.out.print(a[i]);


        return null;
    }
}
