package czatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStart {
/*	public static void main(String[] args) {
		int port = 55555;
		ServerSocket server;
		Socket connection;
		try {
			server = new ServerSocket(port);
			System.out.println("Server started");
		
			while(true) {
				try {
				System.out.println("Waiting for connection.");
					connection = server.accept();
					System.out.println("new Connection");
					DataOutputStream outs = new DataOutputStream(connection.getOutputStream());
					DataInputStream ins = new DataInputStream(connection.getInputStream());
					while(true) {
						try {
							int length = ins.readInt();
							if(length > 0) {
								byte[] message = new byte[length];
								ins.readFully(message, 0, length);
								System.out.println(new String(message));
							}
						}catch(IOException e) {
							System.out.println(e);
							break;
						}
					}
				}catch(IOException e) {
					System.out.println(e);
				}
			}
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	*/
}