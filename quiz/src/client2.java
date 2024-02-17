/*
import jdk.nashorn.internal.ir.SwitchNode;
*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class Client {


    public static void main(String[] args) throws Exception{
        final boolean game = true;
        Socket socket = new Socket("localhost",3000);       // connect to 3000 port on local host.
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        // Get a username from user. Send it to server and see if it's ok or not.
        Scanner in = new Scanner( System.in );
        boolean isUsernameOk = false;
        while (!isUsernameOk){
            System.out.println("Enter your username pleaseee: ");
            String username = in.nextLine();
            dos.writeUTF(username);
            String userValidation = dis.readUTF();
            if (userValidation.startsWith("OK"))
                isUsernameOk = true;
            else
                System.out.println("UserName already exists");
        }

        // This thread waits for server to send a message to it. It then prints it in console.
        Thread messageListener = new Thread(new Runnable() {
            boolean end=false;
            @Override
            public void run() {
                try {
                    String message = dis.readUTF();
                    if(message.equals("Win"))
                        end=true;

                    System.out.println("Incoming message: " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        messageListener.start();

        // This loop gets a target username and a message from user, and sends them to server respectively.
        String msg2 = dis.readUTF();
        System.out.println(msg2);

        while (game) {

            System.out.println("Enter your number: ");
            String s = in.nextLine();
            dos.writeUTF(s);

        }

    }
}

