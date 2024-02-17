import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Clexample {
    public static void main(String[] args){
        try {
            DatagramSocket ds = new DatagramSocket();

            Scanner input = new Scanner(System.in);

            InetAddress ia = InetAddress.getLocalHost();

            byte[] buf1 = null;

            while (true){
                String str = input.nextLine();
                buf1 = str.getBytes();

                DatagramPacket dp = new DatagramPacket(buf1,buf1.length,ia,1000);
                ds.send(dp);

                if (str.equals("bye")){
                    break;
                }
            }

            ds.close();
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

