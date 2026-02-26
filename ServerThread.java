import java.io.*;
import java.net.*;
public class ServerThread implements Runnable {
    private Socket socket;
    private ServerMain server_main;
    public ServerThread (Socket socket, ServerMain server_main) {
        this.socket = socket;
        this.server_main = server_main;
    }
    public void run() {
        try {
            int id = server_main.getClientNumber();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String saludo = "Bienvenido! Eres el cliente " + id;
            if (id % 2 == 0) saludo += ". ¡TIENES MUCHA SUERTE!";
            out.println(saludo + ". ¿Cual es tu nombre?");
            socket.close();
        } catch (Exception e) { }
    }
}
