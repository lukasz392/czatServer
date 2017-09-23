package czatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientHandle implements Runnable{
	
	private Socket connection;
	//private DataOutputStream outs;
	//private DataInputStream ins;
	private OutputStreamWriter outs;
	private InputStreamReader ins;
	private String message;
	
	public ClientHandle(Socket connection) {
		this.connection = connection;
		try {
			outs = new OutputStreamWriter(connection.getOutputStream(), "UTF-16");
			ins = new InputStreamReader(connection.getInputStream(), "UTF-16");
			
		}catch(IOException e) {
			System.out.println(e);
		}
		NewServerStart.socketList.add(outs);
	}
	public void run() {
		System.out.println("Client connected.");
			while(true) {
				try {
					message = receive();
					send(message);
				}catch(IOException e) {
					try {
						if(NewServerStart.socketList.remove(outs)) {
						}
						connection.close();
						System.out.println("client disconnected.");
						break;
					} catch (IOException e1) {
						System.out.println(e1);
					}
					break;
				}
			}
	}
	public String receive() throws IOException{
		int length = ins.read();
		char [] m = "".toCharArray();
		if(length > 0) {
			m = new char[length];
			ins.read(m);
		}
		return new String(m);
	}
	
	public void send(String message) throws IOException{
		int length = message.length();
		for(OutputStreamWriter o : NewServerStart.socketList) {
			
				o.write(length);
				o.write(message);
				o.flush();
			
			
		}
	}
	
}
