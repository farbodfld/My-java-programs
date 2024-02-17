import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Server2 {

    static Map<String, ClientHandler> users;
    static List<ClientHandler> sl = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(3050);


        users = new ConcurrentHashMap<>();

        while (true) {
            Socket socket = serverSocket.accept();
            ClientHandler temp = new ClientHandler(socket);
            (new Thread(temp)).start();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean gamer = true;

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
                if (Server2.users.containsKey(username)) {
                    String errorMessage = "err: UserName already exists... please enter another one: ";
                    this.dos.writeUTF(errorMessage);
                } else {
                    String okMessage = "OK: Username was OK.";
                    this.dos.writeUTF(okMessage);
                    isUsernameOk = true;
                }
            }
            Server2.users.put(username, this);
            ClientHandler targetHandler = Server2.users.get(username);
            Server2.sl.add(targetHandler);
            System.out.println("User " + username + " Connected!");


            while (true) {
                String s1 = dis.readUTF();
                String x = dis.readUTF();
                long answer = Long.parseLong(x);
                String y = dis.readUTF();
                long answer2 = Long.parseLong(y);
                String op = dis.readUTF();
                long an = 0;
                if (op.equals("sub")) {
                    an = answer - answer2;
                } else if (op.equals("add")) {
                    an = answer + answer2;
                } else if (op.equals("divideBy")) {
                    an = answer / answer2;
                } else if (op.equals("multiply")) {
                    an = answer * answer2;
                }
                for (int i = 0; i < Server2.sl.size(); i++) {
                    ClientHandler targetHandler2 = Server2.sl.get(i);
                    targetHandler2.dos.writeUTF(username + "The result of " + answer + " " + op + " " + answer2 + " is: " + an);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


class Client2 {


    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 3050);       // connect to 3050 port on local host.
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        // Get a username from user. Send it to server and see if it's ok or not!
        Scanner in = new Scanner(System.in);
        boolean isUsernameOk = false;
        while (!isUsernameOk) {
            System.out.println("Enter your username please: ");
            String username = in.nextLine();
            dos.writeUTF(username);
            String userValidation = dis.readUTF();
            if (userValidation.startsWith("OK"))
                isUsernameOk = true;
            else
                System.out.println("UserName already exists");
        }

        Thread messageListener = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String message = dis.readUTF();
                        System.out.println("Incoming message: " + message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        messageListener.start();

        String msg = dis.readUTF();
        System.out.println(msg);


        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter first number:");
            int x = in.nextInt();
            System.out.println("enter second number:");
            int y = in.nextInt();
            System.out.println("enter operator:");
            String o = br.readLine();
            dos.writeUTF(String.valueOf(x));
            dos.writeUTF(String.valueOf(y));
            dos.writeUTF(o);
            dos.writeUTF("What is" + x + o + y + " ?");
            dos.flush();
        }
    }
}

