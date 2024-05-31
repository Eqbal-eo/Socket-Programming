import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            System.out.println("Waiting for clients...");
            // Create a server socket listening on port 4999
            ServerSocket socket = new ServerSocket(4999);

            // Accept an incoming connection from a client
            Socket socket2 = socket.accept();
            System.out.println("Connection established");

            // Read data from the client
            BufferedReader userInput = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
            String str = userInput.readLine();
            System.out.println(str);

            // Send a response back to the client
            PrintWriter out = new PrintWriter(socket2.getOutputStream(), true);
            out.println("Server says: " + str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
