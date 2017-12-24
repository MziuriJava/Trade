package ge.mziuri.trade.server.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    
    public static void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                SocketThread socketThread = new SocketThread(socket);
                Thread thread = new Thread(socketThread);
                thread.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
