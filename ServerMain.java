import java.net.*;
public class ServerMain {
    private int clientnumber = 1;
    public ServerMain() throws Exception {
        ServerSocket server_socket = new ServerSocket(2020);
        System.out.println("Servidor iniciado en el puerto 2020...");
        while(true) {
            Socket socket = server_socket.accept();
            new Thread(new ServerThread(socket, this)).start();
        }
    }
    public synchronized int getClientNumber() { return clientnumber++; }
    public static void main(String[] args) {
        try { new ServerMain(); } catch (Exception e) { e.printStackTrace(); }
    }
}
