import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        
        try 
        {
            Socket socket = new Socket("localhost", 6457);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while (true) 
            {
                System.out.print("Enter Message for sent to Server: ");
                String msg = scanner.nextLine();
                dataOutputStream.writeUTF(msg);
                Thread.sleep(100);
                String response = dataInputStream.readUTF();
                System.out.println("Response from server: " + response);
                if (msg.compareTo("End") == 0) 
                {
                    break;
                }
            }
            socket.close();
            scanner.close();
        } 
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
    }
}
