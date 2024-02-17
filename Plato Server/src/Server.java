import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    static Map <String, ClientHandler> users;

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(3500);

        users = new ConcurrentHashMap<>();

        while ( true ) {
            Socket socket = serverSocket.accept();      // wait for a client to connect
            ClientHandler temp = new ClientHandler( socket );   // create a thread for handling new client
            ( new Thread( temp ) ).start();     // start the thread
        }

    }
}

 class ClientHandler implements Runnable {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    ClientHandler(Socket socket) throws Exception {
        this.socket = socket;
        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {

        // Get a username from client. Check if it is unique. if not, send an error message to client and wait for another username.
        String username = "";
        try {
            boolean isUsernameOk = false;
            System.out.println("some one connected");
            while (!isUsernameOk) {
                username = this.dis.readUTF();
                if (Server.users.containsKey(username)) {
                    String errorMessage = "err: UserName already exists... please enter another one: ";
                    this.dos.writeUTF(errorMessage);
                } else {
                    String okMessage = "OK: Username was OK.";
                    this.dos.writeUTF(okMessage);
                    isUsernameOk = true;
                }
            }
            Server.users.put(username, this);       // Create the user in server
            System.out.println("User " + username + " Connected!");

            while (true) {
                String targetName = this.dis.readUTF();     // Get a string from client. It's supposed to be the target username.
                String message = this.dis.readUTF();        // Get another string from client, indicating message.
                ClientHandler targetHandler = Server.users.get(targetName);     // Get the handler for the target username.
                targetHandler.dos.writeUTF(username + " says: " + message);     // Write the message to target username's outputstream.
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
