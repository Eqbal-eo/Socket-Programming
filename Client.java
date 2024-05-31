import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        int port = 4999;
        String ip = "localhost";

        try {
            System.out.println("Client started");
            Socket socket = new Socket(ip, port);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String userMessage;
            while (true) {
                System.out.print("Enter a message (type 'exit' to quit): ");
                userMessage = userInput.readLine();
                output.println(userMessage);

                if (userMessage.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.println(input.readLine());
            }

            System.out.println("Connection closed by client");
            userInput.close();
            input.close();
            output.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
