package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Tronmageddon {

	/**
	 * Execution point for client-side app.
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		TronWorld a = new TronWorld();
		a.show();
		try
		{
			Socket s = new Socket("local host", 9005);
			System.out.println("Connection successful.");
			a.SetSocket(s);
			s.close();
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
			System.exit(-1);
			
		}
	}
}