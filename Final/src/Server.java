import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(555);
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String s1 = "";
        while (!s1.equals("stop")) {
            s1 = dis.readUTF();
            String x = dis.readUTF();
            long answer = Long.parseLong(x);
            String y = dis.readUTF();
            long answer2 = Long.parseLong(y);
            String op = dis.readUTF();
            long an = 0;
            if (op.equals("sub")) {
                an = answer - answer2;
            } else if (op.equals("add")) {
                an = answer + answer2;
            } else if (op.equals("divideBy")) {
                an = answer / answer2;
            } else if (op.equals("multiply")) {
                an = answer * answer2;
            }
            System.out.println("client says: " + s1);
            dos.writeUTF("The result of " + answer + " " + op + " " + answer2 + " is: " + an);
            dos.flush();
        }
        dis.close();
        s.close();
        ss.close();
    }
}

class Client {

    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 555);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = "", s2 = "";
        Scanner in = new Scanner(System.in);
        while (!s1.equals("stop")) {
            System.out.println("enter first number:");
            int x = in.nextInt();
            System.out.println("enter second number:");
            int y = in.nextInt();
            System.out.println("enter operator:");
            String o = br.readLine();
            /*System.out.println("ask your question!");
            s1 = br.readLine();*/
//            dos.writeUTF(s1);
            dos.writeUTF(String.valueOf(x));
            dos.writeUTF(String.valueOf(y));
            dos.writeUTF(o);
            dos.writeUTF("What is" +  x +  o +  y  + " ?");
            dos.flush();
            s2 = dis.readUTF();
            System.out.println("sever says: " + s2);
        }
        dis.close();
        dos.close();
        s.close();
    }
}