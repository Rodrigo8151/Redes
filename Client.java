import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        try {
            // Usaremos esta IP fija para el servidor mas adelante
            Socket socket = new Socket("192.168.10.1", 2020);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Servidor dice: " + in.readLine());
            socket.close();
        } catch (Exception e) { System.out.println("Error de conexion."); }
    }
}
