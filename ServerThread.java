import java.io.*;
import java.net.*;

public class ServerThread implements Runnable {
    private Socket socket;
    private ServerMain server_main;

    public ServerThread (Socket socket, ServerMain server_main) {
        this.socket = socket;
        this.server_main = server_main;
    }

    @Override
    public void run() {
        try {
            int client_number = server_main.getClientNumber();
            System.out.println("Client " + client_number + ". has connected.");

            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            String saludo = "Welcome! You are client number " + client_number;
            if (client_number % 2 == 0) {
                saludo += ". ¡TIENES MUCHA SUERTE!";
            }
            out_socket.println(saludo + ". What's your name? ");

            // Aquí el servidor se queda esperando el nombre
            String message = in_socket.readLine(); 
            System.out.println("Client " + client_number + " says: " + message);

            socket.close();
            System.out.println("Client " + client_number + ". has disconnected.");
        } catch (Exception e) { e.printStackTrace(); }
    }
}
