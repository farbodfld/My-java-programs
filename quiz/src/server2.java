import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Server {
    static  String win="";
    static Map <String, clienthandler> users;
    // ((long)( Math.random()*90000))+10000
    static long number= 1000  ;
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(3000);

        int countround=1;
        users = new ConcurrentHashMap<>();
        LinkedList<clienthandler> list = new LinkedList<>();
        boolean startgame=true;
        while ( startgame ) {
//
            if(win.equals("win")) {
                users.clear();
                startgame=false;
            }
            for (int i=0; i<2; i++) {
                Socket socket = serverSocket.accept();
                clienthandler temp = new clienthandler(socket);

                list.add(temp);
            }
            for (int j=0; j<2; j++){
                clienthandler s=list.get(j);
                Thread x = new Thread(s);
                x.start();

            }
            System.out.println("5 gamer is now available");
            Socket socket = serverSocket.accept();
            clienthandler temp = new clienthandler(socket);
            ( new Thread( temp ) ).start();

        }
        System.out.println("game end");
        countround++;
        System.out.println(" rounf"+countround);
        startgame=true;

    }
}
class clienthandler implements Runnable {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    clienthandler(Socket socket) throws Exception {
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
            boolean game=true;
            dos.writeUTF("The Game is on");

            while (game) {

                String message = this.dis.readUTF();        // Get another string from client, indicating message.
                Long test =  Long.parseLong(message);
                if(  Server.number==test){
                    this.dos.writeUTF("Win");
                    Server.win="win";
                    game=false;

                }
                else {
                    this.dos.writeUTF("Wrong");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
