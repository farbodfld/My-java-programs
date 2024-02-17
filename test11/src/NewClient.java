import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.ServerSocket;

public class NewClient {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost",555);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = "", s2 = "";
        while (!s1.equals("stop")){
            s1 = br.readLine();
            dos.writeUTF(s1);
            dos.flush();
            s2 = dis.readUTF();
            System.out.println("sever says: " + s2);
        }
        dis.close();
        dos.close();
        s.close();
    }
}
