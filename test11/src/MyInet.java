import java.net.*;
import java.io.*;

public class MyInet {
    public static void main(String[] args){
        try {
            InetAddress ip = InetAddress.getByName("www.yahoo.com");
            System.out.println("Host name:" + ip.getHostName());
            System.out.println("Host name:" + ip.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
