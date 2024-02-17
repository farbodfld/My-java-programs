import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Latari_Server {

    public static class Server {

        public static int checking = 0;
        public static int round_counter = 1;
        public static long target_number;
        static Map<String, ClientHandler> users;

        public static void main(String[] args) throws Exception {

            LinkedList<ClientHandler> list = new LinkedList<>();
            ServerSocket serverSocket = new ServerSocket(3000);

            users = new ConcurrentHashMap<>();

            while (true) {
                for (int i = 0; i < 2; i++) {
                    Socket socket = serverSocket.accept();   // wait for a clients to connect
                    ClientHandler temp = new ClientHandler(socket);   // create a thread for handling new clients
                    list.add(temp);
                    checking++;

                }
                for (int j = 0; j < 2; j++) {
                    ClientHandler s = list.get(j);
                    Thread x = new Thread(s);
                    x.start();                    // start the thread

                }
                target_number = ((long) (Math.random() * 90000)) + 10000;
                System.out.println(target_number);

                /*Socket socket = serverSocket.accept();      // wait for a client to connect
                ClientHandler temp = new ClientHandler( socket );   // create a thread for handling new client
                ( new Thread( temp ) ).start();     // start the thread*/
            }

        }
    }

}


class ClientHandler implements Runnable {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    static boolean game = true;
    public static long answer;

    ClientHandler(Socket socket) throws Exception {
        this.socket = socket;
        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {

        // Get a username from client. Check if it is unique. if not, send an error message to client and wait for another username.
        try {
            boolean isUsernameOk = false;
            String username = "";
            while (!isUsernameOk) {
                username = this.dis.readUTF();
                if (Latari_Server.Server.users.containsKey(username)) {
                    String errorMessage = "err: UserName already exists... please enter another one: ";
                    this.dos.writeUTF(errorMessage);
                } else {
                    String okMessage = "OK: Username was OK.";
                    this.dos.writeUTF(okMessage);
                    isUsernameOk = true;
                }
            }
            Latari_Server.Server.users.put(username, this);       // Create the user in server
            System.out.println("User " + username + " Connected!");

            dos.writeUTF("The Game is on");

            while (true) {
                String message = this.dis.readUTF();        // Get another string from client, indicating message.
                answer = Long.parseLong(message);
                if (Latari_Server.Server.target_number == answer) {
                    this.dos.writeUTF("you Won");
                    Latari_Server.Server.round_counter++;
                    /*for (int i = 0; i < Latari_Server.Server.checking; i++) {
                        ClientHandler targetHandler = Latari_Server.Server.users.get(i);
                        targetHandler.dos.writeUTF(username + " Won the game");
                    }*/
                    // game = false;
                    // Latari_Server.Server.target_number = ((long) (Math.random() * 90000)) + 10000;
                    dos.writeUTF("round " + Latari_Server.Server.round_counter + " started");
                    long num = Latari_Server.Server.target_number = ((long) (Math.random() * 90000)) + 10000;
                    System.out.println(num);
                    // Game_Process();
                    /*Latari_Server.Server.win="win";
                    Latari_Server.game=false;*/

                } else {
                    this.dos.writeUTF("Wrong");
                }
                /*String targetName = this.dis.readUTF();     // Get a string from client. It's supposed to be the target username.
                String message = this.dis.readUTF();        // Get another string from client, indicating message.
                ClientHandler targetHandler = Latari_Server.Server.users.get(targetName);     // Get the handler for the target username.
                targetHandler.dos.writeUTF(username + " says: " + message);     // Write the message to target username's outputstream.*/
            }

            /*dos.writeUTF(username + " won the game");
            dos.writeUTF("round " + Latari_Server.Server.round_counter + " started");
            long num = Latari_Server.Server.target_number = ((long) (Math.random() * 90000)) + 10000;
            System.out.println(num);
            game = true;*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
