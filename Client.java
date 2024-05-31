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
            // Connect to the server running on localhost at port 4999
            Socket socket = new Socket(ip, port);

            // Read user input from the console
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a string: ");
            String str = userInput.readLine();

            // Send the input string to the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(str);

            // Read and print the server's response
            BufferedReader Input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(Input.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
