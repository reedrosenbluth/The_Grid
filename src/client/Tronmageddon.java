package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

import base.TronWorld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Tronmageddon implements Runnable {
	static PrintWriter sout = null;

	/**
	 * Execution point for client-side app.
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Grid g = new BoundedGrid(46, 94);
		TronWorld a = new TronWorld(g);
		a.show();
		
		int x = 0;
		int y = 0;
		
		try
		{
			Socket s = new Socket("localhost", 9002);
			a.SetSocket(s);
//			sout = new PrintWriter(s.getOutputStream(), true);
//			sout.println(Color.BLUE.getRGB() + " Tyler");
			BufferedReader stdin = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String stdinLine = stdin.readLine();
			
			while((stdinLine = stdin.readLine()) != null && s.isConnected()){
				String[] p = stdinLine.split(" ");
				if(p[0].equals("."))
				{
					g.put(new Location(Integer.parseInt(p[2]), Integer.parseInt(p[1])), new Bug(new Color(Integer.parseInt(p[3]))));
				}
				System.out.println(stdinLine);
			}
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
			System.exit(-1);
			
		}
	}
	
	public void run() {
		
	}

}
