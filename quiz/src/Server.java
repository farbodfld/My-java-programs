/*
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    public static int checking = 0;
    public static long y;
    static Map<String, ClientHandler> users;

    public static void main(String[] args) throws Exception {


        ArrayList<ClientHandler> list = new ArrayList<>();
        ServerSocket serverSocket = new ServerSocket(3000);

        y = (((long) Math.random() * 90000) + 10000);
        users = new ConcurrentHashMap<>();

        while ( true ) {
            for (int i=0; i<5; i++) {
                Socket socket = serverSocket.accept();
                ClientHandler temp = new ClientHandler(socket);
                list.add(temp);
                checking++;

            }
            for (int j=0; j<5; j++){
                ClientHandler s=list.get(j);
                Thread x = new Thread(s);
                x.start();

            }
            Socket socket = serverSocket.accept();
            ClientHandler temp = new ClientHandler( socket );
            ( new Thread( temp ) ).start();
        }

    }
}

class ClientHandler implements Runnable{

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


        try {
            boolean isUsernameOk = false;
            String username = "";
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
            while (Server.checking<5){

            }
            this.dos.writeUTF("The Game is on");
            Server.users.put(username, this);

            while (true) {
                String message = this.dis.readUTF();
                long cod = Long.parseLong(message);
                if (cod==Server.y){
                    System.out.println(username + "won the round");
                    this.dos.writeUTF("You Won!!");
                    Server.y = ((long) Math.random() * 90000) + 10000;
                    break;
                }else {
                    this.dos.writeUTF("Wrong");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}*/
