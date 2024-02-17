import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Clserver {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(1000);
        byte[] buf = new byte[1024];
        DatagramPacket dp = null;

        while (true){
            dp = new DatagramPacket(buf,buf.length);
            ds.receive(dp);

            String str = new String(dp.getData(),0,dp.getLength());
            System.out.println("client says: " + str);

            if (str.equals("bye")){
                break;
            }

            buf = new byte[1024];
        }

        ds.close();
    }

}
