import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) 
    {
        try 
        {
            ServerSocket serverSocket = new ServerSocket(6457);
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while (true) 
            {
                String msg = dataInputStream.readUTF();
                System.out.println("Message from client: " + msg);
                Thread.sleep(100);
                System.out.print("Enter Messege for sent to Client: ");
                String response = scanner.nextLine();
                dataOutputStream.writeUTF(response); // for message sending
                // dataOutputStream.writeUTF("Message successfully received");
                if (msg.compareTo("End") == 0) 
                {
                    break;
                }
            }
            serverSocket.close();
            socket.close();
        } 
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
    }
}
