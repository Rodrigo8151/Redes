import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // IP de la red interna
            Socket socket = new Socket("192.168.10.1", 2020);
            System.out.println("Successful connection to the server.");

            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            Scanner keyboard = new Scanner(System.in);

            // Leer saludo del servidor
            String message = in_socket.readLine();
            System.out.println("Server says: " + message);

            // Escribir nombre por teclado
            System.out.print("Enter your name: ");
            String myName = keyboard.nextLine();
            out_socket.println(myName);

            socket.close();
            System.out.println("Socket closed.");
        } catch (Exception e) { System.out.println("Error de conexion."); }
    }
}
