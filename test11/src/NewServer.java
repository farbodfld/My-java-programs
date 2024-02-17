import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class NewServer {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(555);
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = "", s2 = "";
        while (!s1.equals("stop")){
            s1 = dis.readUTF();
            System.out.println("client says: " + s1);
            s2 = br.readLine();
            dos.writeUTF(s2);
            dos.flush();
        }
        dis.close();
        s.close();
        ss.close();
    }
}
