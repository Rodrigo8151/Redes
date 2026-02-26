import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    private int clientnumber = 1;

    public ServerMain() throws Exception {
        ServerSocket server_socket = new ServerSocket(2020);
        System.out.println("Port 2020 is now open.");
        while(true) {
            Socket socket = server_socket.accept();
            ServerThread server_thread = new ServerThread(socket, this); 
            new Thread(server_thread).start();
        }
    }

    public synchronized int getClientNumber() {
        return clientnumber++; 
    }

    public static void main(String[] args) {
        try { new ServerMain(); } catch (Exception e) { e.printStackTrace(); }
    }
}
