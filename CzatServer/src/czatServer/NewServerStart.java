package czatServer;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class NewServerStart {
	public static ArrayList<OutputStreamWriter> socketList;
	
	public static void main(String[] args) {
		int port = 55555;
		ServerSocket server;
		Socket connection;
	
		ClientHandle client;
		try{
			socketList = new ArrayList<>();
			server = new ServerSocket(port);
			System.out.println("Server started...\nPress 'ctrl + c' to exit.");
			while(true) {
				 connection = server.accept();
				 client = new ClientHandle(connection);
				 Thread t = new Thread(client);
				 t.start();
				 
				 
			 }
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
