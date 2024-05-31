import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            System.out.println("Waiting for clients...");
            ServerSocket serverSocket = new ServerSocket(4999);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection established");

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;
            while (true) {
                clientMessage = input.readLine();
                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("Client says: " + clientMessage);
                output.println("Server says: " + clientMessage);
            }

            System.out.println("Connection closed by client");
            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
