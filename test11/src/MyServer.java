import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args){

        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = dis.readUTF();
            System.out.println("massage from client:" + str);
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
