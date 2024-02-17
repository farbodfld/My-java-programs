import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 3000);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        Scanner in = new Scanner(System.in);
        Thread messageListener = new Thread(new Runnable() {
            boolean end = false;

            @Override
            public void run() {
                try {
                    String message = dis.readUTF();
                    if (message.equals("Win"))
                        end = true;

                    System.out.println("Incoming message: " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        messageListener.start();

        /*while (true) {

            System.out.println("Enter your number: ");
            String s = in.nextLine();
            dos.writeUTF( s );

        }*/
        dos.close();
        dis.close();

    }

}



